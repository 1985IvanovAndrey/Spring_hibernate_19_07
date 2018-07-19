package com.hibernate.service;

import com.hibernate.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> studentList();

    void addSudent(Student student);

    void updateStudent(Student student);

    void removeStudent(int id);

    Student getById(int id);



}
