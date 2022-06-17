package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    List<Student> findStudent(String lastName);
    Student findStudent(Long id) throws ResourceNotFoundException;
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);

}
