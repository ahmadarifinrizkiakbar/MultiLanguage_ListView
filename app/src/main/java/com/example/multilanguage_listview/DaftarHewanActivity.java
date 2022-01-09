package com.example.multilanguage_listview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.example.multilanguage_listview.model.Hewan;
import com.example.multilanguage_listview.model.Lebah;
import com.example.multilanguage_listview.model.KuraKura;
import com.example.multilanguage_listview.model.LumbaLumba;


public class DaftarHewanActivity extends AppCompatActivity {
    public final static String HEWAN_TERPILIH ="hewan_obj_key";
    List<Hewan> hewans;
    ListView listView;
    String jenisHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_hewan);
        Intent intent = getIntent();
        jenisHewan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        hewans = DataProvider.getHewansByTipe(this,jenisHewan);
        //sesuaikan judul
        TextView txJudul = findViewById(R.id.text_title_daftar);
        String judu = "";
        if (hewans.get(0) instanceof KuraKura) {
            judu = getString(R.string.daftar_ras_kurakura);
        }else if (hewans.get(0) instanceof Lebah) {
            judu = getString(R.string.daftar_ras_lebah);
        }else if (hewans.get(0) instanceof LumbaLumba) {
            judu = getString(R.string.daftar_ras_lumbalumba);
        }
        txJudul.setText(judu);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_hewan);
        DaftarHewanAdapter adapter = new DaftarHewanAdapter(this,hewans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Hewan terpilih = hewans.get(position);
            bukaProfileHewan(terpilih);
        }
    };

    private void bukaProfileHewan(Hewan hewanTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfileHewan.class);
        intent.putExtra(HEWAN_TERPILIH, hewanTerpilih);
        startActivity(intent);
    }
}
