package com.business.beans;

import com.business.model.Exam;
import com.business.service.ExamService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class ExamInputBean {
    private String name;
    private int starting;
    private int duration;
    private String result;

    @Inject
    ExamService examService;

    public void submit(){
        result = examService.insertExam(new Exam(name, starting, duration));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarting() {
        return starting;
    }

    public void setStarting(int starting) {
        this.starting = starting;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
