package com.developeralamin.firechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.developeralamin.firechat.databinding.ActivityForgotBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

    private ActivityForgotBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();

        binding.fogotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.userEmail.getText().toString();

                if (email.isEmpty()) {
                    binding.userEmail.setError("Please Enter your Email");
                    binding.userEmail.requestFocus();
                } else {
                    auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(ForgotActivity.this, LoginActivity.class));
                                finish();
                                Toast.makeText(ForgotActivity.this, "Check now Email", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ForgotActivity.this, "Email is Invailited", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

        });
    }
}