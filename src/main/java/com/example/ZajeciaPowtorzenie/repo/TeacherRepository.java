package com.example.ZajeciaPowtorzenie.repo;

import com.example.ZajeciaPowtorzenie.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
