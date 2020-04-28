package com.example.ZajeciaPowtorzenie.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private Long pesel;

    @ManyToOne
    private Squad squad;
}
