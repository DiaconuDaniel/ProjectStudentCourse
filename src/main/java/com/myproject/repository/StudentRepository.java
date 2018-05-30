package com.myproject.repository;

import com.myproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Daniel.Diaconu on 18/05/28.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findByName(String name);

    @Modifying
    @Query("update Student s set s.name = ?1 where s.id = ?2")
    void updateNameStudent(String name, Integer id);

}
