package com.business.beans;

import com.business.service.StudentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class UpdateStudentBean {
    @Inject
    private StudentService studentService;

    private int idStudent;
    private String nameStudent;
    private String result;

    public void updateStudent(){
        this.result = this.studentService.updateStudent(this.idStudent, this.nameStudent);
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

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
}
