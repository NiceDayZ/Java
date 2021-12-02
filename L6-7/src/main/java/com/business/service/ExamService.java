package com.business.service;


import com.business.model.Exam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class ExamService implements Serializable {

    @PersistenceContext(unitName = "TestJava")
    EntityManager em;


    public List<Exam> getExams(){
        return em.createNamedQuery("Exam.findAll", Exam.class).getResultList();
    }

    public int getNumberOfRows(){
        return 0;
    }

    public int getExamIdByName(String name){
        return 0;
    }

    public String insertExam(Exam exam){
        em.persist(exam);
        return "Success";
    }


}
