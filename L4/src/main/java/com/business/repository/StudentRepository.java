package com.business.repository;

import com.business.model.Exam;
import com.business.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    List<Student> studentList;
    private static StudentRepository singleInstance = null;

    private StudentRepository() {
        ExamRepository examRepository = ExamRepository.getInstance();

        List<Exam> listOfExams1 = new ArrayList<>();
        List<Exam> listOfExams2 = new ArrayList<>();
        List<Exam> listOfExams3 = new ArrayList<>();

        listOfExams1.add(examRepository.getExam(1));
        listOfExams1.add(examRepository.getExam(2));
        listOfExams1.add(examRepository.getExam(3));

        listOfExams2.add(examRepository.getExam(1));
        listOfExams2.add(examRepository.getExam(2));

        listOfExams3.add(examRepository.getExam(3));
        listOfExams3.add(examRepository.getExam(4));

        studentList = new ArrayList<>();
        studentList.add(new Student("Craciun Mihai", listOfExams1));
        studentList.add(new Student("Mihai Craciun", listOfExams1));
        studentList.add(new Student("Mihai Cosmin", listOfExams2));
        studentList.add(new Student("Cosmin Mihai", listOfExams3));
        studentList.add(new Student("Craciun Cosmin", listOfExams3));
        studentList.add(new Student("Cosmin Craciun", listOfExams3));
    }

    public static StudentRepository getInstance(){
        if (singleInstance == null) {
            singleInstance = new StudentRepository();
        }
        return singleInstance;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
