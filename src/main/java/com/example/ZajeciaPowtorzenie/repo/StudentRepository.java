package com.example.ZajeciaPowtorzenie.repo;

import com.example.ZajeciaPowtorzenie.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByLastName(String lastName);
}
