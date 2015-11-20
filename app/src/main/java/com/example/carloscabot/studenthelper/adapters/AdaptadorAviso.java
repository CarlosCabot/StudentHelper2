package com.example.carloscabot.studenthelper.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.clases.Avisos;

import java.util.List;

/**
 * Created by yincong.yu on 19/11/15.
 */
public class AdaptadorAviso extends RecyclerView.Adapter<AdaptadorAviso.AvisosViewHolder> {

    List<Avisos> listaAviso;



    public AdaptadorAviso(List<Avisos> listaAviso) {
        this.listaAviso = listaAviso;
    }

    @Override
    public AvisosViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_aviso, viewGroup,false);
        AvisosViewHolder holder = new AvisosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AvisosViewHolder avisosViewHolder, int i) {
        avisosViewHolder.imgAvisos.setImageResource(listaAviso.get(i).getFoto());
        avisosViewHolder.txtAvisos.setText(listaAviso.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaAviso.size();
    }

    public static class AvisosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgAvisos;
        TextView txtAvisos;

        public AvisosViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgAvisos = (ImageView) itemView.findViewById(R.id.imageAviso);
            txtAvisos = (TextView) itemView.findViewById(R.id.textAviso);
        }


        //@Override
        public void onClick(View v) {
            CharSequence nombreActual = txtAvisos.getText();
            if (nombreActual == "Tienes un nuevo mensaje") {
                Toast.makeText(v.getContext(), "Acceso al Chat", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "Un compañero de tuyo ha enviado una image") {
                Toast.makeText(v.getContext(), "Acceso al Chat privado", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "Un compañero de tuyo ha enviado un mensaje en grupo") {
                Toast.makeText(v.getContext(), "Acceso al chat de grupo", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "¡El profesor tuyo ha añadido un apunte!") {
                Toast.makeText(v.getContext(), "Acceso al Apuntes", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "Noticias: Mañana hay un nexamen.") {
                Toast.makeText(v.getContext(), "Acceso al Chat de profesor", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "Noticias: ¡El profesor tuyo ha calificado tus practicas!") {
                Toast.makeText(v.getContext(), "Acceso al Chat de profesor", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "Noticias: ¡El profesor tuyo ha puesto la nota de la asignatura Química!") {
                Toast.makeText(v.getContext(), "Acceso al Chat de profesor", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "Tu profesor quiere hablar contigo.") {
                Toast.makeText(v.getContext(), "Acceso al Chat de profesor", Toast.LENGTH_SHORT).show();
            } else if (nombreActual == "¡¡Un compañero tuyo te ha retado a Quiz!!") {
                Toast.makeText(v.getContext(), "Acceso al Juegos", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
