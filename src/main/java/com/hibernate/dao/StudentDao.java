package com.hibernate.dao;


import com.hibernate.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> studentList();

    void addSudent(Student student);

    void removeStudent(int id);

    void updateStudent(Student student);

    Student getById(int id);

}
