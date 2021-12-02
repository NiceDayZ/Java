package com.business.model;

import javax.persistence.*;

@Entity
@Table(name = "students_exams")
@NamedQueries({
        @NamedQuery(name = "StudentExam.findByIds", query = "select e from StudentExam e where e.studentId = :std and e.examsId = :exm"),
})
public class StudentExam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "student_id")
    @Basic(optional = false)
    private int studentId;

    @Column(name = "exams_id")
    @Basic(optional = false)
    private int examsId;

    public StudentExam(int studentId, int examsId) {
        this.studentId = studentId;
        this.examsId = examsId;
    }

    public StudentExam() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamsId() {
        return examsId;
    }

    public void setExamsId(int examsId) {
        this.examsId = examsId;
    }
}
