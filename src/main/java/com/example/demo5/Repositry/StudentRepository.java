package com.example.demo5.Repositry;

import com.example.demo5.Modell.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    Student findStudentById(Integer id);
}
