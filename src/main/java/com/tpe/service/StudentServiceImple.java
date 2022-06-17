package com.tpe.service;

import com.tpe.dao.StudentRepositoryImple;
import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImple implements IStudentService {

    private StudentRepositoryImple studentRepositoryImple;

    public StudentServiceImple(StudentRepositoryImple studentRepositoryImple) {
        this.studentRepositoryImple = studentRepositoryImple;
    }

    @Override
    public List<Student> getAll() {
        return studentRepositoryImple.findAll();
    }

    @Override
    public List<Student> findStudent(String lastName) {
        return studentRepositoryImple.findByLastName(lastName);
    }

    @Override
    public Student findStudent(Long id) throws ResourceNotFoundException {
        Student student = studentRepositoryImple.findById(id);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with id" + id);

        }
        return student;
    }

    @Override
    public void createStudent(Student student) {
        studentRepositoryImple.create(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepositoryImple.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepositoryImple.delete(id);

    }
}
