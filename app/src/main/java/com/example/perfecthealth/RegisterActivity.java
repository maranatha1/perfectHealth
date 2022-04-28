package com.example.perfecthealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import models.UserInfo;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etMobNumber, etPassword;
    ImageView btnBack;
    Button btnSignUp;
    TextInputLayout inputLayoutEmail, inputLayoutPassword;
    TextView login;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponent();
        mAuth = FirebaseAuth.getInstance();
    }

    private void initComponent() {
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        etMobNumber = findViewById(R.id.editTextMobile);
        etName = findViewById(R.id.editTextName);
        btnSignUp = findViewById(R.id.btnRegister);
        inputLayoutEmail = findViewById(R.id.textInputEmail);
        inputLayoutPassword = findViewById(R.id.textInputPassword);
        btnBack = findViewById(R.id.btn_back);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (email.isEmpty()) {
            inputLayoutEmail.setError("Email is required");
            inputLayoutEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            inputLayoutEmail.setError("Please enter a valid email address");
        }
        if (password.isEmpty()) {
            inputLayoutPassword.setError("Password is required");
            inputLayoutPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            inputLayoutPassword.setError("Minimum length of password should be at least 6");
            inputLayoutPassword.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new  OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        UserInfo userInfo = new UserInfo();
                        userInfo.setEmailAddress(email);
                        userInfo.setMobileNumber(etMobNumber.getText().toString());
                        userInfo.setName(etName.getText().toString());
                        FirebaseUser user = mAuth.getCurrentUser();
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(userInfo.getName())
                                    .build();
                        assert user != null;
                        user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(RegisterActivity.this, "Authentication successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }
                        });
                    } else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(RegisterActivity.this, "A user with this email address already exists", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                }
        });
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}