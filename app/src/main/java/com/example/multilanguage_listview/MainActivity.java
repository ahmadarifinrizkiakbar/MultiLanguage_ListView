package com.example.multilanguage_listview;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnLebah,btnKura, btnLumba, btnProfil;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

        btnProfil = findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
            }
        });

    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, Profile.class);
    }

    private void inisialisasiView() {
        btnLebah = findViewById(R.id.btn_buka_ras_Lebah);
        btnKura = findViewById(R.id.btn_buka_ras_Kura);
        btnLumba  = findViewById(R.id.btn_buka_ras_Lumba);

        btnLebah.setOnClickListener(view -> bukaGaleri("Lebah"));
        btnKura.setOnClickListener(view -> bukaGaleri("Kura - Kura"));
        btnLumba.setOnClickListener(view -> bukaGaleri("Lumba - Lumba"));

    }

    private void bukaGaleri(String jenisHewan) {
        Log.d("MAIN","Buka activity Lebah");
        Intent intent = new Intent(this, DaftarHewanActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisHewan);
        startActivity(intent);
    }





}