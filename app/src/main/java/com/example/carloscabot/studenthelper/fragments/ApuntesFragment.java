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
import android.widget.ImageView;
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
public class ApuntesFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ApuntesFragment newInstance(int sectionNumber) {
        ApuntesFragment fragment = new ApuntesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ApuntesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_apuntes, container, false);
        final ImageView apuntes = (ImageView) rootView.findViewById(R.id.imgApuntes);
        apuntes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Descargando archivo", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }




    public void download(){
        Toast.makeText(getActivity(), "Descargando archivo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
