package com.coursera.miprimer;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent, false);


        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        Log.e("position",String.valueOf(position));
        Log.e("mascota.getNombre()",mascota.getNombre());
        Log.e("mascota.getFoto()",String.valueOf(mascota.getFoto()));
        Log.e("mascota.getRanking()",String.valueOf(mascota.getRanking()));
        holder.tvRanking.setText(String.valueOf(mascota.getRanking()));


        final TextView tvRanking2 = holder.tvRanking;
        ImageButton botonHuesoBlanco = holder.ibHuesoBlanco;
        botonHuesoBlanco.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.v("ImageButton", "Clicked!");
                //tvRanking2.setText(String.valueOf(mascota.getRanking()+1));
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                holder.tvRanking.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));//String.valueOf(mascota.getRanking()));
               // contactoViewHolder.tvLikes.setText(constructorContactos.obtenerLikesContacto(contacto) + " " + activity.getString(R.string.likes));



            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRanking;
        private ImageButton ibHuesoBlanco;



        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRanking = ( TextView) itemView.findViewById(R.id.tvRanking);
            ibHuesoBlanco = (ImageButton) itemView.findViewById(R.id.ibHuesoBlanco);

        }
    }

}
