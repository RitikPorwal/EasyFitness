package com.example.ritik.easyfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class nav extends Fragment {
    Button d,w,n,r;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_nav, container, false);
        d=(Button)v.findViewById(R.id.diet);
        w=(Button)v.findViewById(R.id.workout);
        r=(Button)v.findViewById(R.id.signout);
        n=(Button)v.findViewById(R.id.notes);

        d.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                Diet diet1 = new Diet();
                ft.replace(R.id.bottom,diet1);
                ft.commit();
            }
        });


        w.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                workout workout1 = new workout();
                ft.replace(R.id.bottom,workout1);
                ft.commit();
            }
        });

        n.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                notes note1 = new notes();
                ft.replace(R.id.bottom,note1);
                ft.commit();
            }
        });

        r.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return v;
    }
}
