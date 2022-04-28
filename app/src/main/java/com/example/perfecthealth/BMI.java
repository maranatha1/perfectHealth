package com.example.perfecthealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        //declaring variables
        final EditText kilos;
        final EditText centimeters;
        final TextView txtresult;
        final TextView totalBMI;
        Button btnCalc;
        Button btnRestart;

        //calling the declared variables
        kilos = (EditText)findViewById(R.id.kilos);
        centimeters = (EditText)findViewById(R.id.centimeters);

        txtresult = (TextView)findViewById(R.id.txtresult);
        totalBMI = (TextView)findViewById(R.id.totalBMI);

        btnCalc = (Button)findViewById(R.id.btnCalc);
        btnRestart = (Button)findViewById(R.id.btnSave);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strWeight = kilos.getText().toString();
                String strHeight = centimeters.getText().toString();

                if(strWeight.equals("")){
                    kilos.setError("Enter your weight");
                    kilos.requestFocus();
                    return;
                }
                if (strHeight.equals("")){
                    centimeters.setError("Enter your height");
                    centimeters.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(strWeight);
                float height = Float.parseFloat(strHeight)/100;

                float bmiValue = BMICalculate(weight,height);
                totalBMI.setText(interpreteBMI(bmiValue));
                txtresult.setText("BMI = " + bmiValue);
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kilos.setText("");
                centimeters.setText("");
                totalBMI.setText("");
                txtresult.setText("");
            }
        });

    }
    public float BMICalculate(float weight,float height){
        return weight / (height * height);
    }
    public String interpreteBMI(float bmiValue){
        if (bmiValue <16){
            return "extremely UnderWeight";
        }
        else if (bmiValue <18.5){
            return "Uderweight";
        }
        else if (bmiValue <25){
            return "Normal";
        }
        else if (bmiValue <30){
            return "OverWeight";
        }
        else
            return "Obese";

    }
}