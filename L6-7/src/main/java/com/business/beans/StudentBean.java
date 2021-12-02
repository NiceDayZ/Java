package com.business.beans;

import com.business.model.Student;
import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@SessionScoped
@ManagedBean
public class StudentBean {

    @Inject
    StudentService studentService;

    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
