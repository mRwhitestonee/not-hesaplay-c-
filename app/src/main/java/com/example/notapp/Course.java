package com.example.notapp;

public class Course {
    public String name;
    public int credit;
    public double midterm;
    public double finalExam;

    public Course(String name, int credit, double midterm, double finalExam) {
        this.name = name;
        this.credit = credit;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public double getAverage() {
        return midterm * 0.4 + finalExam * 0.6;
    }
}
