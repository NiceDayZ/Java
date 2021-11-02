package com.business.service;


import com.business.model.Exam;
import com.business.model.Student;
import com.business.repository.PostgresRepository;
import com.business.repository.StudentRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final PostgresRepository postgresRepository;

    public StudentService(){
        postgresRepository = PostgresRepository.getInstance();
    }

    public List<Student> getStudents(){
        ResultSet resultSet = postgresRepository.runQuery("SELECT * FROM Students;");
        List<Student> studentList = new ArrayList<>();

        while(true){
            try {
                if (!resultSet.next()) break;
                int id = Integer.parseInt(resultSet.getString("id"));
                Student student = new Student(
                        id,
                        resultSet.getString("name"),
                        getStudentsExams(id));
                studentList.add(student);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Exam> getStudentsExams(int studentId){
        ResultSet resultSet = postgresRepository.runQuery("SELECT * FROM STUDENT_EXAMS JOIN exams e on STUDENT_EXAMS.id_exam = e.id where id_student = " + studentId +";");
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

    public String enrollStudentToExam(int studentId, int examId){
        for (Exam exam: this.getStudentsExams(studentId)){
            if(exam.getId() == examId){
                return "Failed: Student is already enrolled at this exam";
            }
        }

        postgresRepository.updateQuery("INSERT INTO STUDENT_EXAMS(id_student, id_exam) values (" + studentId + ", " + examId +");");
        return "Success";
    }

    public String enrollStudentToExam(int studentId, String examName){
        ExamService examService = new ExamService();

        for (Exam exam: this.getStudentsExams(studentId)){
            if(exam.getName().equals(examName)){
                return "Failed: Student is already enrolled at this exam";
            }
        }

        int examId = examService.getExamIdByName(examName);

        if(examId == -1){
            return "Failed: Exam not found";
        }

        postgresRepository.updateQuery("INSERT INTO STUDENT_EXAMS(id_student, id_exam) values (" + studentId + ", " + examId +");");
        return "Success";
    }

    public String insertStudent(Student student){
        //validation

        postgresRepository.updateQuery("Insert into students(id, name) values (" + (this.getNumberOfRows() + 1) + ", '" + student.getName() + "');");
        return "Success";
    }

    public int getNumberOfRows(){

        ResultSet resultSet = postgresRepository.runQuery("SELECT COUNT(*) from students;");

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
}
