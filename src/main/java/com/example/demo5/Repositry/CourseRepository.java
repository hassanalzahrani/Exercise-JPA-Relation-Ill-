package com.example.demo5.Repositry;

import com.example.demo5.Modell.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);



}
