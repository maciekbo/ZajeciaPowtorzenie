package com.example.ZajeciaPowtorzenie.dao;

import com.example.ZajeciaPowtorzenie.model.Teacher;
import com.example.ZajeciaPowtorzenie.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class TeacherDao {
    @Autowired
    private TeacherRepository teacherRepository;

    public void save(@RequestBody Teacher teacher){
        teacherRepository.save(teacher);
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

}
