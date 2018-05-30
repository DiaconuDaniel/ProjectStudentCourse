package com.myproject.controller;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;



    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Integer id) {
        Course course = courseService.getCourseById(id);
        return course;
    }



    @GetMapping("/all")
    public List<Course> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        return courses;
    }


    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }


    @PostMapping("/{courseId}/addStudent")
    public void addStudentToCourse(@PathVariable Integer courseId, @RequestBody Student student) {
        courseService.addStudentToCourse(courseId, student);
    }



    @PutMapping("/update/{id}")
    public void updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        courseService.updateCourse(course);
    }

}
