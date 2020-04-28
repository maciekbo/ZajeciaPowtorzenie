package com.example.ZajeciaPowtorzenie.dao;

import com.example.ZajeciaPowtorzenie.model.Squad;
import com.example.ZajeciaPowtorzenie.model.Student;
import com.example.ZajeciaPowtorzenie.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentDao {
    @Autowired
    private StudentRepository studentRepository;

    public void save(@RequestBody Student student){
        studentRepository.save(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public List<Student> findAllByLastName(@RequestParam String lastName){
        return studentRepository.findAllByLastName(lastName);
    }
    public void deleteById(@RequestParam Long id){
        studentRepository.deleteById(id);
    }
}
