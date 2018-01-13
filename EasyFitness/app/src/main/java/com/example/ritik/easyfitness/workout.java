package com.example.ritik.easyfitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class workout extends Fragment {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    TextView detail1,detail2,detail3,detail4,detail5;
    Button bw;
    int flag=0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_workout, container, false);

        detail1=(TextView)v.findViewById(R.id.detail1);
        detail2=(TextView)v.findViewById(R.id.detail2);
        detail3=(TextView)v.findViewById(R.id.detail3);
        detail4=(TextView)v.findViewById(R.id.detail4);
        detail5=(TextView)v.findViewById(R.id.detail5);
        bw=(Button)v.findViewById(R.id.bw);

    bw.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag=1;
            DatabaseReference Ref1 = myRef.child("workout").child("exercise1");
            Ref1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String val=dataSnapshot.getValue(String.class);
                    detail1.setText(val);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            DatabaseReference Ref2 = myRef.child("workout").child("exercise2");
            Ref2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String val=dataSnapshot.getValue(String.class);
                    detail2.setText(val);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            DatabaseReference Ref3 = myRef.child("workout").child("exercise3");
            Ref3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String val=dataSnapshot.getValue(String.class);
                    detail3.setText(val);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            DatabaseReference Ref4 = myRef.child("workout").child("exercise4");
            Ref4.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String val=dataSnapshot.getValue(String.class);
                    detail4.setText(val);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            DatabaseReference Ref5 = myRef.child("workout").child("exercise5");
            Ref5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String val=dataSnapshot.getValue(String.class);
                    detail5.setText(val);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            bw.setVisibility(View.GONE);
        }
    });

        return v;
    }
}
