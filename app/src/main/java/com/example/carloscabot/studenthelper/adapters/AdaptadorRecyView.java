package com.example.carloscabot.studenthelper.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carloscabot.studenthelper.clases.ChatClase;
import com.example.carloscabot.studenthelper.R;

import java.util.List;

/**
 * Created by javier.suarez on 18/11/15.
 */
public class AdaptadorRecyView extends RecyclerView.Adapter<AdaptadorRecyView.chatsUniversidad> {

    List<ChatClase> listaClases;

    /*Contructor del Adaptador*/
    public AdaptadorRecyView(List<ChatClase> listaClase){
            this.listaClases = listaClase;
    }

    @Override
    public chatsUniversidad onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowitem,viewGroup,false);
        chatsUniversidad chatholder = new chatsUniversidad(view);
        return chatholder;
    }

    @Override
    public void onBindViewHolder(chatsUniversidad chatsUniversidad, int i) {
        chatsUniversidad.imagenAsignatura.setImageResource(listaClases.get(i).getFoto());
        chatsUniversidad.nombreAsignatura.setText(listaClases.get(i).getNombreAsignatura());
    }

    @Override
    public int getItemCount() {
        return listaClases.size();
    }

    /*Contructor del chat*/
    public static class chatsUniversidad extends RecyclerView.ViewHolder{
        ImageView imagenAsignatura;
        TextView nombreAsignatura;
        public chatsUniversidad(View itemView) {
            super(itemView);
            imagenAsignatura = (ImageView) itemView.findViewById(R.id.iconoAsignatura);
            nombreAsignatura = (TextView) itemView.findViewById(R.id.tituloAsignatura);
        }
    }
}
