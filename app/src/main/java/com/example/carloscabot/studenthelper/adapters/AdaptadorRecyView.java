package com.example.carloscabot.studenthelper.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        chatsUniversidad chatUsuarioholder = new chatsUniversidad(view);
        return chatUsuarioholder;
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
    public static class chatsUniversidad extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imagenAsignatura;
        TextView nombreAsignatura;
        public chatsUniversidad(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imagenAsignatura = (ImageView) itemView.findViewById(R.id.iconoAsignatura);
            nombreAsignatura = (TextView) itemView.findViewById(R.id.tituloAsignatura);
        }

        @Override
        public void onClick(View v) {
            CharSequence nombreActual = nombreAsignatura.getText();
            if (nombreActual == "Linguistica") {
                Toast.makeText(v.getContext(), "Acceso al Chat de Linguistica", Toast.LENGTH_SHORT).show();
            }
            else if(nombreActual == "Filologia Inglesa e Hispanica"){
                Toast.makeText(v.getContext(), "Acceso al Chat de Filologia Inglesa e Hispanica", Toast.LENGTH_SHORT).show();
            }
            else if(nombreActual == "Traduccion e Interpretacion"){
                Toast.makeText(v.getContext(), "Acceso al Chat de Traduccion e Interpretacion", Toast.LENGTH_SHORT).show();
            }
            else if(nombreActual == "Gramatica Inglesa"){
                Toast.makeText(v.getContext(), "Acceso al Chat de Gramatica Inglesa", Toast.LENGTH_SHORT).show();
            }
            else if(nombreActual == "Usos basicos de la lengua Inglesa"){
                Toast.makeText(v.getContext(), "Acceso al Chat de Usos Basicos de la Lengua Inglesa", Toast.LENGTH_SHORT).show();
            }
            else if(nombreActual == "Ciencias de la Salud"){
                Toast.makeText(v.getContext(), "Acceso al Chat de Ciencias de la Salud", Toast.LENGTH_SHORT).show();
            }
            else if(nombreActual == "AudioVisuales"){
                Toast.makeText(v.getContext(), "Acceso al Chat de AudioVisuales", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
