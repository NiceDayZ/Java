package com.business.beans;
import com.business.model.Student;
import com.business.service.StudentService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class StudentInputBean {
    private String name;
    private String result;

    @Inject
    StudentService studentService;

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
