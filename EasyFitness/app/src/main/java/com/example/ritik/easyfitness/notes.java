package com.example.ritik.easyfitness;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.SharedPreferences;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



public class notes extends Fragment {

    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    static Set<String> set;
    Button b1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_notes, container, false);
        b1=(Button)v.findViewById(R.id.button2);
        ListView listView = (ListView)v.findViewById(R.id.listView);

        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("com.example.ritik.easyfitness", getActivity().getApplicationContext().MODE_PRIVATE);
        set = sp.getStringSet("notes", null);

        notes.clear();
        if (set != null) {
            notes.addAll(set);
        }
        else {
            notes.add("EDIT THIS, ADD NEW ON RIGHT TOP");
            set = new HashSet<String>();
            set.addAll(notes);
            sp.edit().putStringSet("notes", set).apply();
        }

        arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b=new Bundle(); // to pass info from fragment to another fragment
                b.putString("noteId",position+"");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                editNote en = new editNote();
                en.setArguments(b);
                ft.replace(R.id.abc,en);
                ft.commit();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.add("");

                SharedPreferences sp1 = getActivity().getApplicationContext().getSharedPreferences("com.example.ritik.easyfitness", Context.MODE_PRIVATE);
                if (set == null) {
                    set = new HashSet<String>();
                } else {
                    set.clear();
                }
                set.addAll(notes);
                arrayAdapter.notifyDataSetChanged();

                sp1.edit().remove("notes").apply();
                sp1.edit().putStringSet("notes", set).apply();
                Bundle b=new Bundle(); // to pass info from fragment to another fragment
                b.putString("noteId",notes.size() - 1+"");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                editNote en = new editNote();
                en.setArguments(b);
                ft.replace(R.id.abc,en);
                ft.commit();
            }
        });
        return v;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add) {
            notes.add("");
            SharedPreferences sp1 = getActivity().getApplicationContext().getSharedPreferences("com.example.ritik.easyfitness", Context.MODE_PRIVATE);
            if (set == null) {
                set = new HashSet<String>();
            } else {
                set.clear();
            }

            set.addAll(notes);
            arrayAdapter.notifyDataSetChanged();

            sp1.edit().remove("notes").apply();
            sp1.edit().putStringSet("notes", set).apply();

            Bundle b=new Bundle(); // to pass info from fragment to another fragment
            b.putString("noteId",notes.size() - 1+"");
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();

            editNote en = new editNote();
            en.setArguments(b);
            ft.replace(R.id.abc,en);
            ft.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
