package com.example.ZajeciaPowtorzenie.dao;

import com.example.ZajeciaPowtorzenie.model.Squad;
import com.example.ZajeciaPowtorzenie.repo.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SquadDao {
    @Autowired
    private SquadRepository squadRepository;

    public void save(@RequestBody Squad squad){
        squadRepository.save(squad);
    }

    public List<Squad> findAll(){
        return squadRepository.findAll();
    }

    public List<Squad> findAllByName(@RequestParam String name){
        return squadRepository.findAllByName(name);
    }
    public void deleteById(@RequestParam Long id){
        squadRepository.deleteById(id);
    }

}
