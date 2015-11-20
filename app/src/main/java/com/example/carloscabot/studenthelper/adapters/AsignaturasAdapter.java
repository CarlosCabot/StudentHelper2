package com.example.carloscabot.studenthelper.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.clases.AsignaturasClase;

import java.util.List;

/**
 * Created by ismael.gonzalez on 18/11/15.
 */
public class AsignaturasAdapter extends RecyclerView.Adapter<AsignaturasAdapter.AsigViewHolder> {
    List<AsignaturasClase> listaAsig;

    public AsignaturasAdapter(List<AsignaturasClase> listaAsig) {
        this.listaAsig = listaAsig;
    }

    @Override
    public AsigViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_asignaturas,parent,false);
        AsigViewHolder holder = new AsigViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(AsigViewHolder holder, int position) {
        holder.imgAsig.setImageResource(listaAsig.get(position).getFotoAsig());
        holder.txtAsig.setText(listaAsig.get(position).getNombreAsig());
    }

    @Override
    public int getItemCount() {
        return listaAsig.size();
    }

    public static class AsigViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAsig;
        TextView txtAsig;
        public AsigViewHolder(View itemView) {
            super(itemView);
            imgAsig = (ImageView) itemView.findViewById(R.id.imgAsig);
            txtAsig = (TextView) itemView.findViewById(R.id.txtAsig);
        }
    }
}
