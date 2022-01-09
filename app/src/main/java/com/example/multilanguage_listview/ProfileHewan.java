package com.example.multilanguage_listview;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multilanguage_listview.model.Hewan;
import com.example.multilanguage_listview.model.Lebah;
import com.example.multilanguage_listview.model.KuraKura;
import com.example.multilanguage_listview.model.LumbaLumba;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileHewan extends AppCompatActivity {

    Hewan hewans;
    TextView txJenis,txAsal,txDeskripsi,txJudul;
    ImageView ivFotoHewan;
    Button kembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ras);
        Intent intent = getIntent();
        hewans = (Hewan) intent.getSerializableExtra(DaftarHewanActivity.HEWAN_TERPILIH);
        inisialisasiView();
        tampilkanProfil(hewans);
    }

    private void inisialisasiView() {
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txJudul = findViewById(R.id.txJudul);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoHewan = findViewById(R.id.gambarHewan);
        kembali = findViewById(R.id.btn_back_to_list);
        kembali.setOnClickListener(view -> {
            onBackPressed();
        });

    }


    private void tampilkanProfil(Hewan hewans) {
        Log.d("Lebah","Menampilkan"+hewans.getJenis());
        if (hewans instanceof KuraKura) {
            txJudul.setText(R.string.kurakura_profil);
        }else if (hewans instanceof Lebah) {
            txJudul.setText(R.string.lebah_profil);
        }else if (hewans instanceof LumbaLumba) {
            txJudul.setText(R.string.lumbalumba_profil);
        }
        txJenis.setText(hewans.getRas());
        txAsal.setText(hewans.getLatin());
        txDeskripsi.setText(hewans.getDeskripsi());
        ivFotoHewan.setImageDrawable(this.getDrawable(hewans.getDrawableRes()));
    }
}
