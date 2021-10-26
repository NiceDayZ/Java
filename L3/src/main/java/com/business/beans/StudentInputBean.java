package com.business.beans;

import com.business.model.Exam;
import com.business.model.Student;
import com.business.repository.PostgresRepository;
import com.business.service.ExamService;
import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StudentInputBean {
    private String name;
    private String result;

    StudentService studentService;

    public StudentInputBean(){
        studentService = new StudentService();
    }

    public void submit(){
        result = studentService.insertStudent(new Student(name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
