package com.example.demo5.Service;

import com.example.demo5.Api_exception.ApiException;
import com.example.demo5.Modell.Student;
import com.example.demo5.Repositry.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }



    public void addStudent(Student student) {
        studentRepository.save(student);


    }

    public void updateStudent(Integer id, Student student) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("student not found");


        }
        student1.setName(student.getName());
student1.setAge(student.getAge());
student1.setMajor(student.getMajor());
        studentRepository.save(student1);

    }

    public void deleteStudent(Integer id) {
        Student c = studentRepository.findStudentById(id);
        if (c == null) {
            throw new ApiException("student not found");
        }
        studentRepository.deleteById(id);

    }

    public void changeStudentMajor(Integer studentId, String newMajor) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("student not found");
        }
        student.getCourses().clear();
        student.setMajor(newMajor);
        studentRepository.save(student);
    }
}
