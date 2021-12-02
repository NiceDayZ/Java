package com.business.beans;

import com.business.model.StudentExam;
import com.business.service.EnrolService;
import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@SessionScoped
@ManagedBean
public class EnrolBean {
    private int studentId;
    private int examId;
    private String result;

    @Inject
    private EnrolService enrolService;

    public void submit(){
        result = enrolService.enrollStudentToExam(new StudentExam(studentId, examId));
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
