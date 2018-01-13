package com.example.ritik.easyfitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Diet extends Fragment {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    Spinner spinner,spinner2,spinner3,spinner4;
    TextView cal1,cal2,cal3,cal4,totalcal;
    Button calcb;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_diet, container, false);

        spinner=(Spinner) v.findViewById(R.id.spinner);
        spinner2=(Spinner) v.findViewById(R.id.spinner2);
        spinner3=(Spinner) v.findViewById(R.id.spinner3);
        spinner4=(Spinner) v.findViewById(R.id.spinner4);

        cal1=(TextView)v.findViewById(R.id.cal1);
        cal2=(TextView)v.findViewById(R.id.cal2);
        cal3=(TextView)v.findViewById(R.id.cal3);
        cal4=(TextView)v.findViewById(R.id.cal4);
        totalcal=(TextView)v.findViewById(R.id.totalcal);

        calcb=(Button)v.findViewById(R.id.calcb);

        String[] a={"Omlete","Dosai","Poori"};
        String[] b={"Curry","Chicken","Dal"};
        String[] c={"Coffee","Cookies","Chat"};
        String[] d={"Rice","Chapati","Curd"};

        List<String> list1=new ArrayList<String>();
        for(int i=0;i<a.length;i++)
            list1.add(a[i]);

        List<String> list2=new ArrayList<String>();
        for(int i=0;i<b.length;i++)
            list2.add(b[i]);

        List<String> list3=new ArrayList<String>();
        for(int i=0;i<c.length;i++)
            list3.add(c[i]);

        List<String> list4=new ArrayList<String>();
        for(int i=0;i<d.length;i++)
            list4.add(d[i]);

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter1);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item, list3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(dataAdapter3);
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item, list4);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(dataAdapter4);


        //-------------------------------------------------------------------------------------------------------------
        String m1,m2,m3,m4;
        m1=spinner.getSelectedItem().toString();
        m2=spinner2.getSelectedItem().toString();
        m3=spinner3.getSelectedItem().toString();
        m4=spinner4.getSelectedItem().toString();

        DatabaseReference Ref1 = myRef.child("meals").child("breakfast").child(m1);
        Ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer val1=dataSnapshot.getValue(Integer.class);
                String val=val1.toString();
                cal1.setText(val);
                findSum();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference Ref2 = myRef.child("meals").child("lunch").child(m2);
        Ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer val1=dataSnapshot.getValue(Integer.class);
                String val=val1.toString();
                cal2.setText(val);
                findSum();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference Ref3 = myRef.child("meals").child("brunch").child(m3);
        Ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer val1=dataSnapshot.getValue(Integer.class);
                String val=val1.toString();
                cal3.setText(val);
                findSum();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference Ref4 = myRef.child("meals").child("dinner").child(m4);
        Ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer val1=dataSnapshot.getValue(Integer.class);
                String val=val1.toString();
                cal4.setText(val);
                findSum();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        // On click Refreshes the values ---------------------------------------------------------------------------------------------------------------

        calcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m1,m2,m3,m4;
                m1=spinner.getSelectedItem().toString();
                m2=spinner2.getSelectedItem().toString();
                m3=spinner3.getSelectedItem().toString();
                m4=spinner4.getSelectedItem().toString();

                DatabaseReference Ref1 = myRef.child("meals").child("breakfast").child(m1);
                Ref1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Integer val1=dataSnapshot.getValue(Integer.class);
                        String val=val1.toString();
                        cal1.setText(val);
                        findSum();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                DatabaseReference Ref2 = myRef.child("meals").child("lunch").child(m2);
                Ref2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Integer val1=dataSnapshot.getValue(Integer.class);
                        String val=val1.toString();
                        cal2.setText(val);
                        findSum();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference Ref3 = myRef.child("meals").child("brunch").child(m3);
                Ref3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Integer val1=dataSnapshot.getValue(Integer.class);
                        String val=val1.toString();
                        cal3.setText(val);
                        findSum();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference Ref4 = myRef.child("meals").child("dinner").child(m4);
                Ref4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Integer val1=dataSnapshot.getValue(Integer.class);
                        String val=val1.toString();
                        cal4.setText(val);
                        findSum();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });
            }
        });

        return v;
    }
    public void findSum()
    {
        int sum;
        sum=Integer.parseInt(cal1.getText().toString())+Integer.parseInt(cal2.getText().toString())+Integer.parseInt(cal3.getText().toString())+Integer.parseInt(cal4.getText().toString());
        totalcal.setText("Today you are having "+sum +" Calories!!");
    }

}
