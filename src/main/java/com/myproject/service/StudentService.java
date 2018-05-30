package com.myproject.service;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.repository.CourseRepository;
import com.myproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Daniel.Diaconu on 18/05/28.
 */

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    //get student for id
    public Student getStudentById(Integer id) {
        Student student = studentRepository.getOne(id);
        return student;
    }

    //get all student
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    //add a student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    //add a curse at a student
    public Student addCourseToStudent(Student student, Course course) {
        Course courseSaved = courseRepository.save(course);
        student.getCourseList().add(courseSaved);
        return studentRepository.save(student);
    }

    //update a student
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }


}
