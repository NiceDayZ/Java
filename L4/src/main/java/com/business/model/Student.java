package com.business.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Exam> exams;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        exams = new ArrayList<>();
    }

    public Student(String name){
        this.name = name;
        exams = new ArrayList<>();
    }

    public Student(String name, List<Exam> exams) {
        this.name = name;
        this.exams = exams;
    }

    public Student(int id, String name, List<Exam> exams) {
        this.id = id;
        this.name = name;
        this.exams = exams;
    }

    public void addExam(Exam exam){
        exams.add(exam);
    }

    public String getName() {
        return name;
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int getId() {
        return id;
    }
}
