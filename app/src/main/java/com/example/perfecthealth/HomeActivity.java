package com.example.perfecthealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button btnLogout;
    private CardView cvBmi;
    private CardView cvWorkouts;
    private CardView cvProfile;
    private CardView cvReports;
    private CardView cvCapture;
    private CardView cvMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout = (Button)findViewById(R.id.btnLogoutButton);
        cvBmi = (CardView)findViewById(R.id.cv_bmi);
        cvWorkouts = (CardView)findViewById(R.id.cv_workouts);
        cvProfile = (CardView)findViewById(R.id.cv_profile);
        cvReports = (CardView)findViewById(R.id.cv_reports);
        cvCapture = (CardView)findViewById(R.id.cv_capture);
        cvMeals = (CardView)findViewById(R.id.cv_meals);

        cvBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BMI.class));
            }
        });

        cvWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, WorkoutActivity.class));
            }
        });

        cvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });

        cvCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CaptureActivity.class));
            }
        });

        cvMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MealsActivity.class));
            }
        });

        cvReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ReportActivity.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        if(mAuth.getCurrentUser() == null){
                            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                            finishAffinity();
                        }
                    }
                };
                mAuth = FirebaseAuth.getInstance();
                mAuth.addAuthStateListener(mAuthListener);

                mAuth.signOut();
            }

        });
    }
}