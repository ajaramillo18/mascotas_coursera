package com.coursera.miprimer;
import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return  db.obtenerTodosLosMascotas();
    }



    public void insertarTresMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.TABLE_MASCOTA_NOMBRE, "Canelo");
        contentValues.put(Constantes.TABLE_MASCOTA_FOTO, R.drawable.cachorro_rottweiler);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLE_MASCOTA_NOMBRE, "Lassie");
        contentValues.put(Constantes.TABLE_MASCOTA_FOTO, R.drawable.perro_wero);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLE_MASCOTA_NOMBRE, "Cholo");
        contentValues.put(Constantes.TABLE_MASCOTA_FOTO, R.drawable.xolo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLE_MASCOTA_NOMBRE, "Toby");
        contentValues.put(Constantes.TABLE_MASCOTA_FOTO, R.drawable.perro_lanudo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(Constantes.TABLE_MASCOTA_NOMBRE, "Escuby");
        contentValues.put(Constantes.TABLE_MASCOTA_FOTO, R.drawable.perro_escucha);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(Constantes.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
