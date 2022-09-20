package com.example.nilairatarata;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int KKM = 75;

    private TextView txt_hasil;
    private TextView txt_warning;
    private EditText edt_nilai_tugas;
    private EditText edt_nilai_quiz1;
    private EditText edt_nilai_quiz2;
    private EditText edt_nilai_ets;
    private EditText edt_nilai_eas;
    private EditText edt_nilai_perbaikan_tugas;
    private EditText edt_nilai_perbaikan_quiz1;
    private EditText edt_nilai_perbaikan_quiz2;
    private EditText edt_nilai_perbaikan_ets;
    private EditText edt_nilai_perbaikan_eas;

    private void hitungRataRata() {
        String str_nilai_tugas = edt_nilai_tugas.getText().toString();
        String str_nilai_quiz1 = edt_nilai_quiz1.getText().toString();
        String str_nilai_quiz2 = edt_nilai_quiz2.getText().toString();
        String str_nilai_ets = edt_nilai_ets.getText().toString();
        String str_nilai_eas = edt_nilai_eas.getText().toString();

        String str_nilai_perbaikan_tugas = edt_nilai_perbaikan_tugas.getText().toString();
        String str_nilai_perbaikan_quiz1 = edt_nilai_perbaikan_quiz1.getText().toString();
        String str_nilai_perbaikan_quiz2 = edt_nilai_perbaikan_quiz2.getText().toString();
        String str_nilai_perbaikan_ets = edt_nilai_perbaikan_ets.getText().toString();
        String str_nilai_perbaikan_eas = edt_nilai_perbaikan_eas.getText().toString();

        double tugas = Double.parseDouble(str_nilai_tugas.equals("") ? "0" : str_nilai_tugas);
        double quiz1 = Double.parseDouble(str_nilai_quiz1.equals("") ? "0" : str_nilai_quiz1);
        double quiz2 = Double.parseDouble(str_nilai_quiz2.equals("") ? "0" : str_nilai_quiz2);
        double ets = Double.parseDouble(str_nilai_ets.equals("") ? "0" : str_nilai_ets);
        double eas = Double.parseDouble(str_nilai_eas.equals("") ? "0" : str_nilai_eas);

        double perbaikan_tugas = Double.parseDouble(str_nilai_perbaikan_tugas.equals("") ? "0" : str_nilai_perbaikan_tugas);
        double perbaikan_quiz1 = Double.parseDouble(str_nilai_perbaikan_quiz1.equals("") ? "0" : str_nilai_perbaikan_quiz1);
        double perbaikan_quiz2 = Double.parseDouble(str_nilai_perbaikan_quiz2.equals("") ? "0" : str_nilai_perbaikan_quiz2);
        double perbaikan_ets = Double.parseDouble(str_nilai_perbaikan_ets.equals("") ? "0" : str_nilai_perbaikan_ets);
        double perbaikan_eas = Double.parseDouble(str_nilai_perbaikan_eas.equals("") ? "0" : str_nilai_perbaikan_eas);

        // cek nilai tugas
        if (cekPerluNilaiPerbaikan(tugas, perbaikan_tugas)) {
            tugas = hitungNilaiBaru(perbaikan_tugas);
        } else if (cekDalamRange(tugas, perbaikan_tugas)) {
            displayRangeError("Tugas");
            return;
        }

        // cek nilai quiz1
        if (cekPerluNilaiPerbaikan(quiz1, perbaikan_quiz1)) {
            quiz1 = hitungNilaiBaru(perbaikan_quiz1);
        } else if (cekDalamRange(quiz1, perbaikan_quiz1)) {
            displayRangeError("Quiz 1");
            return;
        }

        // cek nilai quiz2
        if (cekPerluNilaiPerbaikan(quiz2, perbaikan_quiz2)) {
            quiz2 = hitungNilaiBaru(perbaikan_quiz2);
        } else if (cekDalamRange(quiz2, perbaikan_quiz2)) {
            displayRangeError("Quiz 2");
            return;
        }

        // cek nilai ets
        if (cekPerluNilaiPerbaikan(ets, perbaikan_ets)) {
            ets = hitungNilaiBaru(perbaikan_ets);
        } else if (cekDalamRange(ets, perbaikan_ets)) {
            displayRangeError("ETS");
            return;
        }

        // cek nilai eas
        if (cekPerluNilaiPerbaikan(eas, perbaikan_eas)) {
            eas = hitungNilaiBaru(perbaikan_eas);
        } else if (cekDalamRange(eas, perbaikan_eas)) {
            displayRangeError("EAS");
            return;
        }

        double hasil = (tugas + ets + eas + quiz1 + quiz2) / 5.0;

        txt_hasil.setText(String.format("Hasil Rata - Rata : %.2f", hasil));
    }

    private boolean cekPerluNilaiPerbaikan(double nilai, double perbaikan) {
        return nilai < KKM && nilai < perbaikan;
    }

    private double hitungNilaiBaru(double perbaikan) {
        double hasil;
        if (perbaikan > KKM) hasil = KKM;
        else hasil = perbaikan;
        return hasil;
    }

    private boolean cekDalamRange(double tugas, double perbaikan_tugas) {
        return tugas < 0 || tugas > 100 || perbaikan_tugas < 0 || perbaikan_tugas > 100;
    }

    private void displayRangeError(String nilai) {
        txt_warning.setText(String.format("Range Nilai %s dari 0 hingga 100", nilai));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edt_nilai_tugas = findViewById(R.id.edt_nilai_tugas);
        edt_nilai_ets = findViewById(R.id.edt_nilai_ets);
        edt_nilai_eas = findViewById(R.id.edt_nilai_eas);
        edt_nilai_quiz1 = findViewById(R.id.edt_nilai_quiz1);
        edt_nilai_quiz2 = findViewById(R.id.edt_nilai_quiz2);

        edt_nilai_perbaikan_tugas = findViewById(R.id.edt_nilai_perbaikan_tugas);
        edt_nilai_perbaikan_ets = findViewById(R.id.edt_nilai_perbaikan_ets);
        edt_nilai_perbaikan_eas = findViewById(R.id.edt_nilai_perbaikan_eas);
        edt_nilai_perbaikan_quiz1 = findViewById(R.id.edt_nilai_perbaikan_quiz1);
        edt_nilai_perbaikan_quiz2 = findViewById(R.id.edt_nilai_perbaikan_quiz2);

        txt_hasil = findViewById(R.id.txt_hasil);
        txt_warning = findViewById(R.id.txt_warning);

        Button btn_hitung = findViewById(R.id.btn_hitung);

        btn_hitung.setOnClickListener(view -> {
            txt_warning.setText("");
            hitungRataRata();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}