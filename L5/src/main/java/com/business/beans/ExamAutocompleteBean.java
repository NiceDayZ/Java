package com.business.beans;

import com.business.model.Exam;
import com.business.service.ExamService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@RequestScoped
public class ExamAutocompleteBean {

    @Inject
    ExamService examService;

    public List<String> completeText(String query) {

        String queryLowerCase = query.toLowerCase();
        List<String> examList = new ArrayList<>();
        List<Exam> exams = examService.getExams();
        for (Exam exam : exams) {
            examList.add(exam.getName());
        }

        return examList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
}
