package com.example.carloscabot.studenthelper.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.clases.TemasClase;

import java.util.List;

/**
 * Created by ismael.gonzalez on 18/11/15.
 */
public class TemasAdapter extends RecyclerView.Adapter<TemasAdapter.TemasViewHolder> {
    List<TemasClase> listaTemas;

    public TemasAdapter(List<TemasClase> listaTemas) {
        this.listaTemas = listaTemas;
    }

    @Override
    public TemasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_temas,parent,false);
        TemasViewHolder holder = new TemasViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TemasViewHolder holder, int position) {
        holder.imgTema.setImageResource(listaTemas.get(position).getFotoTema());
        holder.txtTema.setText(listaTemas.get(position).getNombreTema());
    }

    @Override
    public int getItemCount() {
        return listaTemas.size();
    }

    public static class TemasViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTema;
        TextView txtTema;
        public TemasViewHolder(View itemView) {
            super(itemView);
            imgTema = (ImageView) itemView.findViewById(R.id.imgTema);
            txtTema = (TextView) itemView.findViewById(R.id.txtTema);
        }
    }
}
