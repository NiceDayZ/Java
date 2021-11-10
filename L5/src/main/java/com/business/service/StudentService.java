package com.business.service;


import com.business.model.Exam;
import com.business.model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentService {

    @PersistenceContext(unitName = "TestJava")
    EntityManager em;

    public List<Student> getStudents(){
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public Student getStudentById(int id){return em.find(Student.class, id);}

    public List<Exam> getStudentsExams(int studentId){
        return null;
    }


    public String insertStudent(Student student){
        em.persist(student);
        return "Success";
    }

    public String deleteStudent(int id){
        Student student = em.find(Student.class, id);

        if(student == null){
            return "No student found with this id";
        }

        em.remove(student);
        return "Success";
    }

    public String updateStudent(int id, String name){
        Student student = em.find(Student.class, id);

        if(student == null){
            return "No student found with this id";
        }

        em.createNamedQuery("Student.updateStudent", Student.class).setParameter("name", name).setParameter("id", id).executeUpdate();

        return "Success";
    }

    public int getNumberOfRows(){
        return 0;
    }
}
