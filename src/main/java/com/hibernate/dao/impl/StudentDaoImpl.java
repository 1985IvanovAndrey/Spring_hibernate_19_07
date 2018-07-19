package com.hibernate.dao.impl;

import com.hibernate.dao.StudentDao;
import com.hibernate.entity.Student;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> studentList() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Student> theQuery = session.createQuery("from Student", Student.class);
//        return theQuery.getResultList();
        Session session=sessionFactory.getCurrentSession();
        List<Student>studentList=session.createQuery("from Student").list();
        return studentList;
    }

    @Override
    public void addSudent(Student student) {
        Session session=sessionFactory.getCurrentSession();
        session.persist(student);
    }

    @Override
    public void removeStudent(int id) {
        Session session=sessionFactory.getCurrentSession();
        Student student=(Student)session.load(Student.class,new Integer(id));
        if (student!=null){
            session.delete(student);
        }
    }

    @Override
    public void updateStudent(Student student) {
        Session session=sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    public Student getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = (Student)session.load(Student.class, new Integer(id));
        return student;
    }
}
