package com.business.repository;

import com.business.model.Exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamRepository {
    private static List<Exam> listOfExams;

    private static ExamRepository singleInstance = null;

    private ExamRepository(){
        listOfExams = new ArrayList<>();
        listOfExams.add(new Exam(1,"Java", 9, 90));
        listOfExams.add(new Exam(2,"FMSE", 10, 180));
        listOfExams.add(new Exam(3,"Ingineria Programarii", 11, 60));
        listOfExams.add(new Exam(4, "PM", 12, 60));
    }

    public static ExamRepository getInstance(){
        if (singleInstance == null) {
            singleInstance = new ExamRepository();
        }
        return singleInstance;
    }

    public List<Exam> getListOfExams() {
        return listOfExams;
    }

    public Exam getExam(int id){
        for(Exam exam: listOfExams){
            if(exam.getId() == id){
                return exam;
            }
        }
        return null;
    }
}
