package com.example.demo5.Controller;

import com.example.demo5.Modell.Course;
import com.example.demo5.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("add")
    public ResponseEntity addTeacher(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("course added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("course updated successfully");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("course deleted successfully");
    }

    @GetMapping("/{id}/teacher")
    public ResponseEntity<String> getTeacherNameByCourseId(@PathVariable int id) {
        String teacherName = courseService.getTeacherNameByCourseId(id);
        return ResponseEntity.ok(teacherName);
    }
    @PutMapping("{course_id}/assign/{teacher_id}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer course_id,@PathVariable Integer teacher_id){
courseService.assignCourseToTeacher(course_id,teacher_id);
return ResponseEntity.status(200).body("course assigned successfully");
    }

@GetMapping("/get/{course_id}")
    public ResponseEntity getStudentByCourseId(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(courseService.getStudentsByCourseId(course_id));
    }

    @PutMapping("{student_id}/assign/{course_id}")

    public ResponseEntity assignMerchantAndCustomers(@PathVariable Integer student_id, @PathVariable Integer course_id) {
        courseService.assignStudentToCourse(student_id, course_id);
        return ResponseEntity.status(200).body("merchent assigned");
    }



























}