package com.myproject.controller;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentById(id);
        return student;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> list = studentService.getAllStudent();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }


    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {

        studentService.addStudent(student);
        return student;
    }


    @PostMapping("/{studentId}/addCourse")
    public void addCourseToStudent(@PathVariable Integer studentId, @RequestBody Course course) {
        studentService.addCourseToStudent(studentId, course);
    }


    @PutMapping("update/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateStudent(student);
    }


}
