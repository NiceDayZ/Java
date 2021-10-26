package com.business.beans;

import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EnrolBean {
    private int studentId;
    private int examId;
    private String result;

    private final StudentService studentService;

    public EnrolBean(){
        studentService = new StudentService();
    }

    public void submit(){
        result = studentService.enrollStudentToExam(studentId, examId);
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
