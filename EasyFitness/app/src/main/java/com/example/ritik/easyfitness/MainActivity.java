package com.example.ritik.easyfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    Button b1;
    EditText e1, e2;
    String u_name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actn=getSupportActionBar();
        actn.hide();
        //Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Easy Fitness");*/
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                u_name=e1.getText().toString().toLowerCase();
                pass=e2.getText().toString();
                if(!(u_name.equals("")) && !(pass.equals(""))) {
                    DatabaseReference Ref1 = myRef.child("users").child(u_name);
                    Ref1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                String val = dataSnapshot.getValue(String.class);
                                if (val.equals(pass)) {
                                    Intent intent = new Intent(getBaseContext(), Main3Activity.class);
                                    intent.putExtra("username", u_name);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "No Such User found!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Enter All Details!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
