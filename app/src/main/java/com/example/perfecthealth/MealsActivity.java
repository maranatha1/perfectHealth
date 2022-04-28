package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MealsActivity extends AppCompatActivity {

    //declaring variable
    Button btnDay1;
    Button btnDay2;
    Button btnDay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        //calling the declared variables
        btnDay1 = (Button)findViewById(R.id.btnD1);
        btnDay2  =(Button)findViewById(R.id.btnD2);
        btnDay3 = (Button)findViewById(R.id.btnD3);

        btnDay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent day1 = new Intent(MealsActivity.this,Day1.class);
                startActivity(day1);//redirecting to the next page
            }
        });
        btnDay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent day2 = new Intent(MealsActivity.this,Day2.class);
                startActivity(day2);//redirecting to the next page
            }
        });
        btnDay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent day3 = new Intent(MealsActivity.this,Day3.class);
                startActivity(day3);//redirecting to the next page
            }
        });
    }
}