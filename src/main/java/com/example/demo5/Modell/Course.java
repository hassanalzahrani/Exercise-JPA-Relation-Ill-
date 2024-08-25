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
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;




    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;



}
