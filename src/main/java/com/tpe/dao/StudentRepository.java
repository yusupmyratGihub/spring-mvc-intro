package com.tpe.dao;

import com.tpe.domain.Student;

import java.util.List;
public interface StudentRepository {
    List<Student> findAll();
    List<Student> findByLastName(String name);
    Student findById(Long id);
    void create(Student student);
    void update(Student student);
    void delete(Long id);
}
