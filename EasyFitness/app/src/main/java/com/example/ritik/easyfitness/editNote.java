package com.example.ritik.easyfitness;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;

import java.util.HashSet;


public class editNote extends Fragment implements TextWatcher {
    int noteId;
    Button bs;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_edit_note, container, false);
        bs=(Button)v.findViewById(R.id.button3);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                notes n = new notes();
                ft.replace(R.id.abc,n);
                ft.commit();


            }});

        EditText editText = (EditText) v.findViewById(R.id.editText);
        Bundle x = getArguments();
        String noteIdstr = x.getString("noteId");
        noteId=Integer.parseInt(noteIdstr);
        if (noteId != -1) {
            editText.setText(notes.notes.get(noteId));
        }

        editText.addTextChangedListener(this);

        return v;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        notes.notes.set(noteId, String.valueOf(s));
        notes.arrayAdapter.notifyDataSetChanged();

        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("com.example.ritik.easyfitness", Context.MODE_PRIVATE);

        if (notes.set == null) {
            notes.set = new HashSet<String>();
        } else {
            notes.set.clear();
        }
        notes.set.addAll(notes.notes);
        sp.edit().remove("notes").apply();
        sp.edit().putStringSet("notes", notes.set).apply();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}