package com.example.carloscabot.studenthelper.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carloscabot.studenthelper.clases.ChatClase;
import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.fragments.ChatFragment;
import com.example.carloscabot.studenthelper.fragments.FilologiaInglesaHispanica;

import java.util.List;

/**
 * Created by javier.suarez on 18/11/15.
 */
public class AdaptadorRecyView extends RecyclerView.Adapter<AdaptadorRecyView.ChatsUniversidad>  {

    List<ChatClase> listaClases;


    /*Contructor del Adaptador*/
    public AdaptadorRecyView(List<ChatClase> listaClase){
            this.listaClases = listaClase;
    }

    @Override
    public ChatsUniversidad onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowitem_chat, viewGroup, false);
        ChatsUniversidad chatUsuarioholder = new ChatsUniversidad(view);
        return chatUsuarioholder;
    }

    @Override
    public void onBindViewHolder(ChatsUniversidad chatsUniversidad, int i) {
        final ChatClase itemList = listaClases.get(i);

        chatsUniversidad.imagenAsignatura.setImageResource(listaClases.get(i).getFoto());
        chatsUniversidad.nombreAsignatura.setText(listaClases.get(i).getNombreAsignatura());
        chatsUniversidad.layoutClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombreActual= itemList.getNombreAsignatura();
                Fragment fragment=null;
                //CharSequence nombreActual = nombreAsignatura.getText();
                if (nombreActual.equals("Linguistica")) {
                    Toast.makeText(v.getContext(), "Acceso al Chat de Linguistica", Toast.LENGTH_SHORT).show();
                }
                else if(nombreActual.equals("Filologia Inglesa e Hispanica")){
                    fragment= FilologiaInglesaHispanica.newInstance("Filologia Inglesa e Hispanica");
                    Toast.makeText(v.getContext(), "Acceso al Chat de Filologia Inglesa e Hispanica", Toast.LENGTH_SHORT).show();
                }
                else if(nombreActual.equals("Traduccion e Interpretacion")){
                    Toast.makeText(v.getContext(), "Acceso al Chat de Traduccion e Interpretacion", Toast.LENGTH_SHORT).show();
                }
                else if(nombreActual.equals("Gramatica Inglesa")){
                    Toast.makeText(v.getContext(), "Acceso al Chat de Gramatica Inglesa", Toast.LENGTH_SHORT).show();
                }
                else if(nombreActual.equals("Usos basicos de la lengua Inglesa")){
                    Toast.makeText(v.getContext(), "Acceso al Chat de Usos Basicos de la Lengua Inglesa", Toast.LENGTH_SHORT).show();
                }
                else if(nombreActual.equals("Ciencias de la Salud")){
                    Toast.makeText(v.getContext(), "Acceso al Chat de Ciencias de la Salud", Toast.LENGTH_SHORT).show();
                }
                else if(nombreActual.equals("AudioVisuales")){
                    Toast.makeText(v.getContext(), "Acceso al Chat de AudioVisuales", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaClases.size();
    }


    /*Contructor del chat*/
    public static class ChatsUniversidad extends RecyclerView.ViewHolder {
        RelativeLayout layoutClickable;
        ImageView imagenAsignatura;
        TextView nombreAsignatura;
        public ChatsUniversidad(View itemView) {
            super(itemView);

            imagenAsignatura = (ImageView) itemView.findViewById(R.id.iconoAsignatura);
            nombreAsignatura = (TextView) itemView.findViewById(R.id.tituloAsignatura);
            layoutClickable=(RelativeLayout) itemView.findViewById(R.id.layout_clickable);

        }
    }

}
