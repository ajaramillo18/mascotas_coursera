package com.coursera.miprimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;


import java.util.ArrayList;

public class Mascotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        setSupportActionBar(miActionBar);

        RecyclerView listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        ArrayList<Mascota> mascotaArrayList = new ArrayList<>();
        mascotaArrayList.add(new Mascota(R.drawable.perro_escucha,"Canelo", 23));
        mascotaArrayList.add(new Mascota(R.drawable.perro_lanudo,"Cali", 10));
        mascotaArrayList.add(new Mascota(R.drawable.perro_wero,"Chispa", 30));
        mascotaArrayList.add(new Mascota(R.drawable.cachorro_rottweiler,"Angel", 30));
        mascotaArrayList.add(new Mascota(R.drawable.xolo,"Dante", 30));

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotaArrayList);

        listaMascotas.setAdapter(adaptador);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(R.id.itemFavoritas ==item.getItemId())
        {
            Intent intento = new Intent(Mascotas.this, MascotasFavoritas.class);
            startActivity(intento);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
