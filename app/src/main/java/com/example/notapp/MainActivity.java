package com.example.notapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerDersler;
    EditText etNot1, etNot2;
    Button btnHesapla;
    TextView tvSonuc;

    String[] dersler = {
            "GNL450 - Kariyer Planlama",
            "MBP102 - Veri Yapıları ve Algoritmalar",
            "MBP104 - Veri Tabanı Sistemleri ve Yönetimi",
            "MBP202 - Mobil Uygulamalar",
            "MBP204 - Yazılım Güvenliği",
            "MBP206 - Yapay Zeka Uygulamaları",
            "MBP214 - Yazılım Sınama ve Doğrulama",
            "MBP276 - Sanallaştırma Sistemleri",
            "MBP277 - Python Programlama",
            "MBP282 - Bulut Bilişim"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDersler = findViewById(R.id.spinnerDersler);
        etNot1 = findViewById(R.id.etNot1);
        etNot2 = findViewById(R.id.etNot2);
        btnHesapla = findViewById(R.id.btnHesapla);
        tvSonuc = findViewById(R.id.tvSonuc);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, dersler);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDersler.setAdapter(adapter);

        btnHesapla.setOnClickListener(v -> {
            try {
                double vize = Double.parseDouble(etNot1.getText().toString());
                double finall = Double.parseDouble(etNot2.getText().toString());
                double ort = (vize * 0.4) + (finall * 0.6);

                tvSonuc.setText(spinnerDersler.getSelectedItem().toString()
                        + "\nOrtalama: " + String.format("%.2f", ort));
            } catch (Exception e) {
                Toast.makeText(this, "Lütfen geçerli notlar girin.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
