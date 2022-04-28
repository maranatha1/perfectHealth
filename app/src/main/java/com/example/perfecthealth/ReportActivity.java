package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportActivity extends AppCompatActivity {

    //declaring variables
    Button btnBarChart;
    Button btnPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        btnBarChart = (Button)findViewById(R.id.btnBarChart);
        btnBarChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bar = new Intent(ReportActivity.this, BarChartActivity.class);
                startActivity(bar);
            }
        });
        btnPieChart = (Button)findViewById(R.id.btnPieChart);
        btnPieChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pie = new Intent(ReportActivity.this, PieChartActivity.class);
                startActivity(pie);
            }
        });
    }
}