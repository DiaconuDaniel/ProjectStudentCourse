package com.myproject.service;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.repository.CourseRepository;
import com.myproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Daniel.Diaconu on 18/05/29.
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    //get course for id
    public Course getCourseById(Integer id) {
        Course course = courseRepository.getOne(id);
        return course;
    }


    //get all course
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    //add a curse
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    //add a student at course
    public Course addStudentToCourse(Course course, Student student) {
        Student studentSaved = studentRepository.save(student);
        course.getStudentList().add(studentSaved);
        return courseRepository.save(course);
    }


    //update a course
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }


}
