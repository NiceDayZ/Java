package com.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "exams")
@NamedQueries({
        @NamedQuery(name = "Exam.findAll", query = "select e from Exam e"),
})
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "hour")
    private int date;

    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;

    public Exam(int id, String name, int date, int duration) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    public Exam(String name, int date, int duration) {
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    public Exam() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
