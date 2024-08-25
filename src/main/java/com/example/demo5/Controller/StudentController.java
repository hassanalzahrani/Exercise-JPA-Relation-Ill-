package com.example.demo5.Controller;

import com.example.demo5.Modell.Student;
import com.example.demo5.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }


    @PostMapping("/add")
    public ResponseEntity addcutomer(@Valid @RequestBody Student student) {
        studentService.addStudent(student);

        return ResponseEntity.status(200).body("student added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid@RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("student updated");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted");
    }

    @PutMapping("/{student_id}/chang-major")
    public ResponseEntity changeStudentMajor(@PathVariable Integer student_id,@Valid @RequestBody String major) {
        studentService.changeStudentMajor(student_id, major);
        return ResponseEntity.status(200).body("student major updated");
    }
}
