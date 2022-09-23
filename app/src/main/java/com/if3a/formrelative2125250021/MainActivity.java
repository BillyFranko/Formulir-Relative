package com.if3a.formrelative2125250021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText etNPM,etNama;
    private RadioButton rbJK;
    private RadioGroup rgJK;
    private Spinner spProdi;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNPM = findViewById(R.id.et_npm);
        etNama = findViewById(R.id.et_nama);
        rgJK = findViewById(R.id.rg_jk);
        spProdi = findViewById(R.id.sp_prodi);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String npm, nama, jk, prodi;
                int selectedID;

                npm = etNPM.getText().toString();
                nama = etNama.getText().toString();
                prodi = spProdi.getSelectedItem().toString();

                selectedID = rgJK.getCheckedRadioButtonId();
                rbJK = findViewById(selectedID);
                jk = rbJK.getText().toString();

                //cek edittext npm dan nama kosong
                if(npm.trim().equals(""))
                {
                    etNPM.setError("NPM TIDAK BOLEH KOSONG");
                    return;
                }
                else if(nama.trim().equals(""))
                {
                    etNPM.setError("NAMA TIDAK BOLEH KOSONG");
                    return;
                }

                //panggil intent, kirim data ke ResultActivity
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("varNPM",npm);
                intent.putExtra("varNama",nama);
                intent.putExtra("varJk",jk);
                intent.putExtra("varProdi",prodi);
                startActivity(intent);
            }
        });
    }
}