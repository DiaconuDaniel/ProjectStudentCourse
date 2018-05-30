package com.myproject.service;

import com.myproject.model.Course;
import com.myproject.model.Student;
import com.myproject.repository.CourseRepository;
import com.myproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    public Student getStudentById(Integer id) {
        Student student = studentRepository.getOne(id);
        return student;
    }


    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    public void addCourseToStudent(Integer studentId, Course course) {
        Student student = studentRepository.getOne(studentId);
        Course courseSaved = courseRepository.save(course);
        student.getCourseList().add(courseSaved);
        studentRepository.save(student);
    }


    public void updateStudent(Student student) {
        studentRepository.save(student);
    }





}
