package com.business.beans;

import com.business.model.Student;
import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@RequestScoped
@ManagedBean
public class StudentBean {
    StudentService studentService;

    public StudentBean(){
        studentService = new StudentService();
    }

    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
