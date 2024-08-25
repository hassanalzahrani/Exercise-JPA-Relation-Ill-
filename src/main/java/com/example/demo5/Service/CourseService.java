package com.example.demo5.Service;

import com.example.demo5.Api_exception.ApiException;
import com.example.demo5.Modell.Course;
import com.example.demo5.Modell.Student;
import com.example.demo5.Modell.Teacher;
import com.example.demo5.Repositry.CourseRepository;
import com.example.demo5.Repositry.StudentRepository;
import com.example.demo5.Repositry.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

private final CourseRepository courseRepository;
private final TeacherRepository teacherRepository;
private final StudentRepository studentRepository;

public List<Course> getAllCourses() {

    return (List<Course>) courseRepository.findAll();
}


    public Course addCourse(Course customer) {
       return courseRepository.save(customer);


    }

    public void updateCourse(Integer id, Course course) {
        Course course1 = courseRepository.findCourseById(id);
        if (course1 == null) {
            throw new ApiException("customer not found");


        }
        course1.setName(course1.getName());

        courseRepository.save(course1);

    }

    public void deleteCourse(Integer id) {

    Course course1 = courseRepository.findCourseById(id);
    if (course1 == null) {
        throw new ApiException("customer not found");

    }
    courseRepository.delete(course1);
    }


    public String getTeacherNameByCourseId(int courseId) {
        Course course1= courseRepository.findCourseById(courseId);
        if (course1 == null) {
            throw new ApiException("Course ID not found");
        }
        Teacher teacher = course1.getTeacher();
        if (teacher == null) {
            throw new ApiException("Teacher ID not found");
        }
        return teacher.getName();
    }
    public void assignCourseToTeacher(Integer course_id, Integer teacher_id) {
    Course course1= courseRepository.findCourseById(course_id);
    if (course1 == null) {
        throw new ApiException("Course ID not found");

    }
    Teacher teacher1= teacherRepository.findTeacherById(teacher_id);
    if (teacher1 == null) {
        throw new ApiException("Teacher ID not found");
    }
    course1.setTeacher(teacher1);
    courseRepository.save(course1);

    }

    public List<Student> getStudentsByCourseId(Integer courseId) {
    Course course1= courseRepository.findCourseById(courseId);
    if (course1 == null) {
        throw new ApiException("Course ID not found");
    }
    return studentRepository.findAll();
    }


    public void assignStudentToCourse(Integer student_id, Integer course_id) {

        Course course1= courseRepository.findCourseById(course_id);
        Student student1 = studentRepository.findStudentById(student_id);
        if (course1 == null ) {
            throw new ApiException(" course id not found");
        }
        if (student1 == null) {
            throw new ApiException("student id not found");
        }
      course1.getStudents().add(student1);
        student1.getCourses().add(course1);
        courseRepository.save(course1);
        studentRepository.save(student1);
    }
}


































