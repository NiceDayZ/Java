package com.business.model;

import java.util.Date;

public class Exam {
    private int id;
    private String name;
    private int date;
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
}
