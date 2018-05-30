package com.myproject.repository;

import com.myproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel.Diaconu on 18/05/29.
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    public Course findByName(String name);

    @Modifying
    @Query("update Course c set c.name = ?1 where c.id = ?2")
    void updateNameCourse(String name, Integer id);

}
