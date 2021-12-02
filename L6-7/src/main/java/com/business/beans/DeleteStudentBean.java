package com.business.beans;

import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class DeleteStudentBean {
    @Inject
    private StudentService studentService;

    private int idStudent;
    private String result;

    public void deleteStudent(){
        this.result = this.studentService.deleteStudent(this.idStudent);
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int id_student) {
        this.idStudent = id_student;
    }

    public String getResult() {
        return result;
    }
}
