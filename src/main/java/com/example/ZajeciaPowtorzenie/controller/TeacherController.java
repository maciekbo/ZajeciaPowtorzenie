package com.example.ZajeciaPowtorzenie.controller;

import com.example.ZajeciaPowtorzenie.dao.SquadDao;
import com.example.ZajeciaPowtorzenie.dao.TeacherDao;
import com.example.ZajeciaPowtorzenie.model.Squad;
import com.example.ZajeciaPowtorzenie.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/teacher")
@Controller
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private SquadDao squadDao;

    @GetMapping("")
    public String main(Model model){
        model.addAttribute("allTeacher", teacherDao.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newTeacher(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("newTeacher", teacher);
        List<Squad> squads = squadDao.findAll();
        model.addAttribute("squads", squads);
        return "newTeacher";
    }

}
