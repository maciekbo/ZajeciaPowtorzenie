package com.example.ZajeciaPowtorzenie.controller;

import com.example.ZajeciaPowtorzenie.dao.SquadDao;
import com.example.ZajeciaPowtorzenie.model.Squad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/squad")
@Controller
public class SquadController {
    @Autowired
    private SquadDao squadDao;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("allSquads", squadDao.findAll());
        return "index";
    }

    @RequestMapping("/add")
    public String showForm(Model model){
        Squad squad = new Squad();
        model.addAttribute("newSquad", squad);
        return "new_squad";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("newSquad") Squad squad){
        squadDao.save(squad);
        return "redirect:/";
    }

    @GetMapping("/search/{name}")
    public ModelAndView findSquadsByName(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView("find_squad");
        List<Squad> squadList = squadDao.findAllByName(name);
        modelAndView.addObject("squadsByName", squadList);
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSquadById(@PathVariable Long id){
        squadDao.deleteById(id);
    }
}
