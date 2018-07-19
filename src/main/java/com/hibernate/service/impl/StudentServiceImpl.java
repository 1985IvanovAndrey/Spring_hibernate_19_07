package com.hibernate.service.impl;

import com.hibernate.dao.StudentDao;
import com.hibernate.entity.Student;
import com.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> studentList() {
        return studentDao.studentList();
    }

    @Override
    @Transactional
    public void addSudent(Student student) {
        studentDao.addSudent(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        studentDao.removeStudent(id);
    }

    @Override
    @Transactional
    public Student getById(int id) {
        return studentDao.getById(id);
    }
}
