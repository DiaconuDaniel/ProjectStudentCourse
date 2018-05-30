package com.myproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel.Diaconu on 18/05/28.
 */
@Entity
@Table(name = "course")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {


    @ManyToMany(mappedBy = "courseList")
    //@JsonIgnore
    //  @JsonManagedReference
    //@JsonView
    //@JsonBackReference
    private List<Student> studentList = new ArrayList<>();


    public List<Student> getStudentList() {
        return studentList;
    }

    public Course(String name) {
        this.name = name;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Id
    @Column(name = "course_id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
