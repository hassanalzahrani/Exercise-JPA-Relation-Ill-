package com.example.demo5.Repositry;

import com.example.demo5.Modell.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


    Teacher findTeacherById(Integer id);
}