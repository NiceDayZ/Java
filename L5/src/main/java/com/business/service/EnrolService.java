package com.business.service;

import com.business.model.StudentExam;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EnrolService {
    @PersistenceContext(unitName = "TestJava")
    EntityManager em;

    public String enrollStudentToExam(StudentExam studentExam){
        List<StudentExam> examList = em.createNamedQuery("StudentExam.findByIds", StudentExam.class)
                .setParameter("std", studentExam.getStudentId())
                .setParameter("exm", studentExam.getExamsId())
                .getResultList();

        if(examList.size() > 0){
            return "Fail: Student already enrolled at this exam";
        }


        em.persist(studentExam);
        return "Success";
    }

}
