package com.example.demo5.Modell;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Teacher {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false,unique = true,length = 100)
    private String email;
    @Column(nullable = false)
    private Integer salary;



    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Addreess addreess;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;




}
