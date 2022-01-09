package com.example.multilanguage_listview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.multilanguage_listview.model.Hewan;
import com.example.multilanguage_listview.model.Lebah;
import com.example.multilanguage_listview.model.KuraKura;
import com.example.multilanguage_listview.model.LumbaLumba;


public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<KuraKura> initDataKuraKura(Context ctx) {
        List<KuraKura> Kura = new ArrayList<>();
        Kura.add(new KuraKura(ctx.getString(R.string.name_kuraAustralia), "Aldabra",
                ctx.getString(R.string.desc_kuraAustralia), R.drawable.kura_aldabra));
        Kura.add(new KuraKura(ctx.getString(R.string.name_kura_indonesia), "Asian Forest Tortoise",
                ctx.getString(R.string.desc_kura_indoesia), R.drawable.kura_asian_forest_tortoise));
        Kura.add(new KuraKura(ctx.getString(R.string.name_kura_paraguay), "Cherry Head",
                ctx.getString(R.string.desc_kura_paraguay), R.drawable.kura_cherry_head));
        Kura.add(new KuraKura(ctx.getString(R.string.name_kura_afrika), "Leopard Tortoise",
                ctx.getString(R.string.desc_kura_afrika), R.drawable.kura_leopard_tortoise));
        Kura.add(new KuraKura(ctx.getString(R.string.name_kura_india), "Indian Star",
                ctx.getString(R.string.desc_kura_india), R.drawable.kura_indian_star));
        Kura.add(new KuraKura(ctx.getString(R.string.name_kura_madaskar), "Radiata",
                ctx.getString(R.string.desc_kura_madaskar), R.drawable.kura_radiata));
        return Kura;
    }

    private static List<Lebah> initDataLebah(Context ctx) {
        List<Lebah> lebahs = new ArrayList<>();
        lebahs.add(new Lebah(ctx.getString(R.string.name_LebahAsiaSelatan), "Apis Cerana",
                ctx.getString(R.string.desc_LebahAsiaSelatan), R.drawable.apis_cerana));
        lebahs.add(new Lebah(ctx.getString(R.string.name_LebahAsiaTimur), "Apis Mellifera",
                ctx.getString(R.string.desc_LebahAsiaTimur), R.drawable.apis_mellifera));
        lebahs.add(new Lebah(ctx.getString(R.string.name_LebahIndonesia), "Apis Dorsata",
                ctx.getString(R.string.desc_LebahIndonesia), R.drawable.apis_dorsata));
        lebahs.add(new Lebah(ctx.getString(R.string.name_LebahFlores), "Apis Florea",
                ctx.getString(R.string.desc_LebahFlores), R.drawable.apis_florea));
        lebahs.add(new Lebah(ctx.getString(R.string.name_LebahIndonesia2), "Trigona Sp",
                ctx.getString(R.string.desc_LebahIndonesia2), R.drawable.trigona_sp));
        return lebahs;
    }

    private static List<LumbaLumba> initDataLumbaLumba(Context ctx) {
        List<LumbaLumba> lumba = new ArrayList<>();
        lumba.add(new LumbaLumba(ctx.getString(R.string.name_lumba_malaysia), "Lagenodelphis hosei Fraser",
                ctx.getString(R.string.desc_lumba_malaysia), R.drawable.lumba_fraser));
        lumba.add(new LumbaLumba(ctx.getString(R.string.name_lumba_australia), "Steno bredanensi",
                ctx.getString(R.string.desc_lumba_australia), R.drawable.lumba_gigikasar));
        lumba.add(new LumbaLumba(ctx.getString(R.string.name_lumba_indonesia), "Stenella coeruleoalba",
                ctx.getString(R.string.desc_lumba_indonesia), R.drawable.lumba_hidungbelang));
        lumba.add(new LumbaLumba(ctx.getString(R.string.name_lumba_amerika), "Tursiops truncatus",
                ctx.getString(R.string.desc_lumba_amerika), R.drawable.lumba_hidungbotol));
        lumba.add(new LumbaLumba(ctx.getString(R.string.name_lumba_indopasifik), "Stenella longirostris",
                ctx.getString(R.string.desc_lumba_indopasifik), R.drawable.lumba_pemintal));
        lumba.add(new LumbaLumba(ctx.getString(R.string.name_lumba_atlantik), "Grampus griseus",
                ctx.getString(R.string.desc_lumba_atlantik), R.drawable.lumba_risso));
        return lumba;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataKuraKura(ctx));
        hewans.addAll(initDataLumbaLumba(ctx));
        hewans.addAll(initDataLebah(ctx));

    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}
