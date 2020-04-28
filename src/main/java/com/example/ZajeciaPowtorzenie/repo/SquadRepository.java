package com.example.ZajeciaPowtorzenie.repo;

import com.example.ZajeciaPowtorzenie.model.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquadRepository extends JpaRepository<Squad,Long> {
    List<Squad> findAllByName(String name);
}
