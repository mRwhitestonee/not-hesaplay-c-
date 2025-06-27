package com.example.notapp;

import java.util.ArrayList;

public class SemesterDataHolder {
    private static ArrayList<Semester> semesterList;

    public static void setSemesterList(ArrayList<Semester> list) {
        semesterList = list;
    }

    public static ArrayList<Semester> getSemesterList() {
        return semesterList;
    }
}
