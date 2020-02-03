package com.coursera.miprimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        ArrayList<Mascota> mascotaArrayList = new ArrayList<>();
        mascotaArrayList.add(new Mascota(R.drawable.perro_escucha,"Canelo", 23));
        mascotaArrayList.add(new Mascota(R.drawable.perro_lanudo,"Cali", 10));
        mascotaArrayList.add(new Mascota(R.drawable.perro_wero,"Chispa", 30));
        mascotaArrayList.add(new Mascota(R.drawable.cachorro_rottweiler,"Angel", 30));
        mascotaArrayList.add(new Mascota(R.drawable.xolo,"Dante", 30));

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotaArrayList, this);

        listaMascotas.setAdapter(adaptador);

    }
}
