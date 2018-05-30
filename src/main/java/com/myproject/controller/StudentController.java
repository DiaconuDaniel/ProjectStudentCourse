package com.myproject.controller;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Daniel.Diaconu on 18/05/28.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //get a student after id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentById(id);
        return student;
    }

    //get all student from data base
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> list = studentService.getAllStudent();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }


    //add a new Student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {

        studentService.addStudent(student);
        return student;
    }


    //modificat
    @PostMapping("/addCourse")
    public Student addCourseToStudent(@RequestBody Student student, @RequestBody Course course) {
        studentService.addCourseToStudent(student, course);
        return student;
    }


    //update a student
    @PutMapping("update/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateStudent(student);
    }

}
