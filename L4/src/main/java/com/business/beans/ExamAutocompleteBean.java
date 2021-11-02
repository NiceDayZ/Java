package com.business.beans;

import com.business.model.Exam;
import com.business.service.ExamService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@RequestScoped
public class ExamAutocompleteBean {
    public List<String> completeText(String query) {
        ExamService examService = new ExamService();
        String queryLowerCase = query.toLowerCase();
        List<String> examList = new ArrayList<>();
        List<Exam> exams = examService.getExams();
        for (Exam exam : exams) {
            examList.add(exam.getName());
        }

        return examList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
}
