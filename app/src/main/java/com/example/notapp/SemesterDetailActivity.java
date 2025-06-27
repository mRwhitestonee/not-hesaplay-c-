package com.example.notapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SemesterDetailActivity extends AppCompatActivity {
    Semester semester;
    ArrayAdapter<String> adapter;
    ListView listView;
    TextView avgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_detail);

        int index = getIntent().getIntExtra("index", 0);
        semester = SemesterDataHolder.getSemesterList().get(index);

        listView = findViewById(R.id.courseListView);
        avgText = findViewById(R.id.semAvgText);
        Button addButton = findViewById(R.id.addCourseButton);

        addButton.setOnClickListener(v -> {
            semester.courses.add(new Course("Ders " + (semester.courses.size() + 1), 3, 70, 80));
            updateList();
        });

        updateList();
    }

    void updateList() {
        ArrayList<String> courseNames = new ArrayList<>();
        for (Course c : semester.courses) {
            courseNames.add(c.name + " - Ort: " + String.format("%.2f", c.getAverage()));
        }
        avgText.setText("Dönem Ortalaması: " + String.format("%.2f", semester.getAverage()));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseNames);
        listView.setAdapter(adapter);
    }
}
