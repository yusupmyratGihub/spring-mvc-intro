package com.tpe.dao;

import com.tpe.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImple implements StudentRepository {

   private Map<Long,Student> studentMap=new HashMap<>();
    public StudentRepositoryImple() {
        Student student1=new Student();
        student1.setId(1L);
        student1.setFistName("John");
        student1.setLastName("Coffee");
        student1.setGrade(10);
        Student student2=new Student();
        student2.setId(2L);
        student2.setFistName("James");
        student2.setLastName("Bond");
        student2.setGrade(11);

        Student student3=new Student();
        student3.setId(3L);
        student3.setFistName("Darth");
        student3.setLastName("Vader");
        student3.setGrade(9);
        Student student4=new Student();
        student4.setId(4L);
        student4.setFistName("Iron");
        student4.setLastName("Man");
        student4.setGrade(10);
        studentMap.put(student1.getId(), student1);
        studentMap.put(student2.getId(), student2);
        studentMap.put(student3.getId(), student3);
        studentMap.put(student4.getId(), student4);

    }
   @Override
    public List<Student> findAll() {
        return new ArrayList<Student>(studentMap.values());
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return studentMap.values().stream().filter(s->s.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public Student findById(Long id) {
        return studentMap.get(id);
    }

    @Override
    public void create(Student student) {
        student.setId(new Date().getTime());
        studentMap.put(student.getId(),student);

    }

    @Override
    public void update(Student student) {
        studentMap.replace(student.getId(),student);

    }

    @Override
    public void delete(Long id) {
        studentMap.remove(id);

    }
}
