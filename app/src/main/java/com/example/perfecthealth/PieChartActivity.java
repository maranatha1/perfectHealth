package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

//Reference:https://youtu.be/vhKtbECeazQ
public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
//
        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> vistors = new ArrayList<>();
        vistors.add((new PieEntry(45, 2016)));
        vistors.add((new PieEntry(20, 2017)));
        vistors.add((new PieEntry(50, 2018)));
        vistors.add((new PieEntry(60, 2019)));
        vistors.add((new PieEntry(70, 2020)));

        PieDataSet pieDataSet = new PieDataSet(vistors,"weight kg");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);

        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("weight");
        pieChart.animate();
    }
}