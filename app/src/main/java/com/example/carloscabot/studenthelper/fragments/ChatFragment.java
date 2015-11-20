package com.example.carloscabot.studenthelper.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.carloscabot.studenthelper.clases.ChatClase;
import com.example.carloscabot.studenthelper.main.MainActivity;
import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.adapters.AdaptadorRecyView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by carlos.cabot on 17/11/15.
 */
public class ChatFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ChatFragment newInstance(int sectionNumber) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ChatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*Creamos a partir del rootView en inglado del Layout*/
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
        /*Creacion de la RecyclerView, findViewById se relaciona con el .xml que contendra esta RecyclerView*/
        RecyclerView rcview = (RecyclerView) rootView.findViewById(R.id.RecyclerView);
        /*Mangaer Layout, es un Layout dinamico para contener todos los elementos de nuestra lista*/
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rcview.setLayoutManager(llm);
        /*Creacion de los elementos de la lista en modo HARDCODE*/
        List<ChatClase> listaChat = Arrays.asList(new ChatClase(R.mipmap.libro, "Filología Inglesa e Hispánica"),
                                                  new ChatClase(R.mipmap.traduccion, "Traducción e Interpretación"),
                                                  new ChatClase(R.mipmap.lingu, "Linguística"),
                                                  new ChatClase(R.mipmap.gramar, "Gramática Inglesa"),
                                                  new ChatClase(R.mipmap.ubasing, "Usos básicos de la lengua Inglesa"),
                                                  new ChatClase(R.mipmap.ciencia, "Ciencias de la Salud"),
                                                  new ChatClase(R.mipmap.audiovisual, "Audiovisuales")
                                                  );
        /*Llamada al adapter creado en la clase AdaptadorRecyView.java*/
        AdaptadorRecyView adapter = new AdaptadorRecyView(listaChat);
        rcview.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}


