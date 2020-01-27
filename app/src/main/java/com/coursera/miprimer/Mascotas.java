package com.coursera.miprimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Mascotas extends AppCompatActivity implements RecyclerViewFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        setSupportActionBar(miActionBar);

        //if (toolbar!= null)
           // setSupportActionBar(toolbar);

/*
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

 */


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemFavoritas:
                Intent intento = new Intent(Mascotas.this, MascotasFavoritas.class);
                startActivity(intento);
                break;
            case R.id.itemAcercaDe:
                Intent intentoAcercaDe = new Intent(Mascotas.this, AcercaDe.class);
                startActivity(intentoAcercaDe);
                break;
            case R.id.itemContacto:
                Intent intentoContacto = new Intent(Mascotas.this, ContactoActivity.class);
                startActivity(intentoContacto);

                break;


        }
       /* if(R.id.itemFavoritas ==item.getItemId())
        {
            Intent intento = new Intent(Mascotas.this, MascotasFavoritas.class);
            startActivity(intento);
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager((viewPager));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perro);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
