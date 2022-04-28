package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> weight = new ArrayList<>();
        weight.add(new BarEntry(2014,40 ));
        weight.add(new BarEntry(2015,47 ));
        weight.add(new BarEntry(2016,50 ));
        weight.add(new BarEntry(2017,59 ));
        weight.add(new BarEntry(2018,50 ));
        weight.add(new BarEntry(2019,60 ));
        weight.add(new BarEntry(2020,70 ));

        BarDataSet barDataSet = new BarDataSet(weight,"weight");
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextColor(16);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Health and Fitness");
        barChart.animateY(2000);
    }
}