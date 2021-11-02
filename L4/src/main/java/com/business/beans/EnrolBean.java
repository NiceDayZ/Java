package com.business.beans;

import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class EnrolBean {
    private int studentId;
    private String examName;
    private String result;

    private final StudentService studentService;

    public EnrolBean(){
        studentService = new StudentService();
    }

    public void submit(){
        result = studentService.enrollStudentToExam(studentId, examName);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
