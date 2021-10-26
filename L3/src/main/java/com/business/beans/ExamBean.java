package com.business.beans;

import com.business.model.Exam;
import com.business.service.ExamService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean
public class ExamBean {
    ExamService examService;

    public ExamBean(){
        examService = new ExamService();
    }

    public List<Exam> getExams(){
        return examService.getExams();
    }
}
