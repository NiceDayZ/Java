package com.business.service;


import com.business.model.Exam;
import com.business.repository.ExamRepository;
import com.business.repository.PostgresRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamService {

    private final ExamRepository examRepository;
    private final PostgresRepository postgresRepository;

    public ExamService() {
        examRepository = ExamRepository.getInstance();
        postgresRepository = PostgresRepository.getInstance();
    }

//    public List<Exam> getExams(){
//        return examRepository.getListOfExams();
//    }

    public List<Exam> getExams(){
        ResultSet resultSet = postgresRepository.runQuery("SELECT * FROM EXAMS;");
        List<Exam> examList = new ArrayList<>();

        while(true){
            try {
                if (!resultSet.next()) break;
                examList.add(new Exam(
                        Integer.parseInt(resultSet.getString("id")),
                        resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("hour")),
                        Integer.parseInt(resultSet.getString("duration"))));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return examList;
    }

    public int getNumberOfRows(){

        ResultSet resultSet = postgresRepository.runQuery("SELECT COUNT(*) from exams;");

        int count = 0;
        while(true){
            try {
                if (!resultSet.next()) break;
                    count = Integer.parseInt(resultSet.getString("count"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    public String insertExam(Exam exam){

        if(exam.getDuration() < 10 || exam.getDuration() > 720){
            return "Failed: Exam duration must be between 10 and 720 minutes";
        }
        if(exam.getDate() < 8 || exam.getDate() > 20){
            return  "Failed: Exam starting hour must be between 8 and 20";
        }

        postgresRepository.runQuery("INSERT into exams(id, name, hour, duration) values ("
                + (this.getNumberOfRows() + 1)
                +", " + "'"
                + exam.getName()
                + "', "
                + exam.getDate()
                + ", "
                + exam.getDuration()
                + ")");

        return "Success";
    }


}
