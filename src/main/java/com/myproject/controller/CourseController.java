package com.myproject.controller;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Daniel.Diaconu on 18/05/29.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    //get a course after id
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Integer id) {
        Course course = courseService.getCourseById(id);
        return course;
    }


    //get all courses
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        return courses;
    }

    //add a new course
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    //add a student at course
    @PostMapping("/addStudent")
    public Course addStudentToCourse(@RequestBody Student student, @RequestBody Course course) {
        courseService.addStudentToCourse(course, student);
        return course;
    }


    //update a new course
    @PutMapping("/update/{id}")
    public void updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        courseService.updateCourse(course);
    }

}
