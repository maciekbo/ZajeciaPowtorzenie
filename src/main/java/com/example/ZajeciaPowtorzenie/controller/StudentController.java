package com.example.ZajeciaPowtorzenie.controller;

import com.example.ZajeciaPowtorzenie.dao.SquadDao;
import com.example.ZajeciaPowtorzenie.dao.StudentDao;
import com.example.ZajeciaPowtorzenie.model.Squad;
import com.example.ZajeciaPowtorzenie.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
@RequestMapping("/student")
@Controller
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("allStudents", studentDao.findAll());
        return "index";
    }

    @RequestMapping("/add")
    public String showForm(Model model){
        Squad squad = new Squad();
        model.addAttribute("newStudent", squad);
        return "new_student";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("newStudent") Student student){
        studentDao.save(student);
        return "redirect:/";
    }

    @GetMapping("/search/{lastName}")
    public ModelAndView findSquadsByName(@PathVariable("lastName") String lastName){
        ModelAndView modelAndView = new ModelAndView("find_student");
        List<Student> studentList = studentDao.findAllByLastName(lastName);
        modelAndView.addObject("studentsByLastname", studentList);
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSquadById(@PathVariable Long id){
        studentDao.deleteById(id);
    }
}
