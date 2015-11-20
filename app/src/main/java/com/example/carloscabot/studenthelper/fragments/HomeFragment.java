package com.example.carloscabot.studenthelper.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carloscabot.studenthelper.adapters.AdaptadorAviso;
import com.example.carloscabot.studenthelper.clases.Avisos;
import com.example.carloscabot.studenthelper.main.MainActivity;
import com.example.carloscabot.studenthelper.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by carlos.cabot on 17/11/15.
 */
public class HomeFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private TextView textSection;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeFragment newInstance(int sectionNumber) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView rV = (RecyclerView) rootView.findViewById(R.id.list_aviso);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rV.setLayoutManager(llm);
        List<Avisos> listaaviso = Arrays.asList(new Avisos(R.mipmap.ic_chat, "Tienes un nuevo mensaje"),
                new Avisos(R.mipmap.ic_chat, "Un compañero de tuyo ha enviado una image"),
                new Avisos(R.mipmap.ic_chat, "Un compañero de tuyo ha enviado un mensaje en grupo"),
                new Avisos(R.mipmap.ic_apuntes, "¡El profesor tuyo ha añadido un apunte!"),
                new Avisos(R.mipmap.ic_examen, "Noticias: Mañana hay un nexamen."),
                new Avisos(R.mipmap.ic_examen, "Noticias: ¡El profesor tuyo ha calificado tus practicas!"),
                new Avisos(R.mipmap.ic_examen, "Noticias: ¡El profesor tuyo ha puesto la nota de la asignatura Química!"),
                new Avisos(R.mipmap.ic_profesor, "Tu profesor quiere hablar contigo."),
                new Avisos(R.mipmap.ic_juego, "¡Un compañero tuyo te ha retado a Quiz!")
        );
        AdaptadorAviso adapter = new AdaptadorAviso(listaaviso);
        rV.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
