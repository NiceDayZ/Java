package com.business.beans;

import com.business.model.Exam;
import com.business.service.ExamService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ExamBean implements Serializable {

    @Inject
    ExamService examService;

    public List<Exam> getExams(){
        return examService.getExams();
    }
}
