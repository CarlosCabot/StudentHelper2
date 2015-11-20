package com.example.carloscabot.studenthelper.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carloscabot.studenthelper.R;
import com.example.carloscabot.studenthelper.adapters.TemasAdapter;
import com.example.carloscabot.studenthelper.clases.RecyclerItemClickListener;
import com.example.carloscabot.studenthelper.clases.TemasClase;
import com.example.carloscabot.studenthelper.main.MainActivity;
import java.util.Arrays;
import java.util.List;

/**
 * Created by carlos.cabot on 17/11/15.
 */
public class TemasFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TemasFragment newInstance(int sectionNumber) {
        TemasFragment fragment = new TemasFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TemasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_temas, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.listaTemas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        List<TemasClase> listaTemas = Arrays.asList(new TemasClase(R.mipmap.ic_launcher,"Tema 1"),
                new TemasClase(R.mipmap.ic_launcher,"Tema 2")
        );
        rv.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment=null;
                switch (position){
                    case 0:
                        fragment = ApuntesFragment.newInstance(position + 1);
                        break;
                    case 1:
                        fragment = ApuntesFragment.newInstance(position + 1);
                        break;
                }

                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
            }
        }));
        TemasAdapter adaptador = new TemasAdapter(listaTemas);
        rv.setAdapter(adaptador);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
