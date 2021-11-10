package com.business.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select e from Student e"),
        @NamedQuery(name = "Student.updateStudent", query = "update Student set name = :name where id = :id"),
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    @Basic(optional = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

    public Student() {

    }

    public void addExam(Exam exam){
        exams.add(exam);
    }

    public void removeExam(Exam exam) {exams.remove(exam);}

    public String getName() {
        return name;
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
