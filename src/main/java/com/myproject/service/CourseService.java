package com.myproject.service;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.repository.CourseRepository;
import com.myproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;


    public Course getCourseById(Integer id) {
        Course course = courseRepository.getOne(id);
        return course;
    }


    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }


    public void addStudentToCourse(Integer courseId, Student student) {
        Course course = courseRepository.getOne(courseId);
        Student studentSaved = studentRepository.save(student);
        course.getStudentList().add(studentSaved);
        courseRepository.save(course);
    }


    public void updateCourse(Course course) {
        courseRepository.save(course);
    }


}
