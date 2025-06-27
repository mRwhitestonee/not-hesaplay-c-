package com.example.notapp;

import java.util.ArrayList;

public class Semester {
    public String name;
    public ArrayList<Course> courses = new ArrayList<>();

    public Semester(String name) {
        this.name = name;
    }

    public double getAverage() {
        double total = 0;
        int creditSum = 0;
        for (Course c : courses) {
            total += c.getAverage() * c.credit;
            creditSum += c.credit;
        }
        return creditSum == 0 ? 0 : total / creditSum;
    }
}
