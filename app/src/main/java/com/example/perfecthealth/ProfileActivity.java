package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//Reference: https://youtu.be/_ST5-rll4k0
public class ProfileActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    //declaring variables
    EditText fName;
    EditText lName;
    RadioGroup radioGroup;
    Button btnSave;
    EditText age;
    String gender;
    DatabaseProfile db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        db = new DatabaseProfile(this );//Database connection

        //calling the declared variables
        fName=(EditText) findViewById(R.id.fName);
        lName = (EditText)findViewById(R.id.lName);
        age = (EditText)findViewById(R.id.txtage);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        btnSave=(Button)findViewById(R.id.btnSave);
        radioGroup.setOnCheckedChangeListener(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setContentView((R.layout.activity_show_profile));

//                TextView sfname, slname, sgender, sage;
//
//                sfname = (TextView) findViewById(R.id.fName);
//                slname = (TextView) findViewById(R.id.lName);
//                sgender = (TextView) findViewById(R.id.show_gender);
//                sage = (TextView) findViewById(R.id.show_age);
//
//                sfname.setText("Maranatha");
//                slname.setText("Mantla");
//                sgender.setText("Female");
//                sage.setText("21");

                startActivity(new Intent(ProfileActivity.this, ShowProfile.class));
            }
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i)
        {
            case R.id.rdbMale:
                gender="Male";
                break;

            case R.id.rdbFemale:
                gender="Female";
                break;
        }
    }
}