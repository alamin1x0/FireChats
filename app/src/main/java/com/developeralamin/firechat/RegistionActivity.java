package com.developeralamin.firechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.developeralamin.firechat.databinding.ActivityRegistionBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import es.dmoral.toasty.Toasty;

public class RegistionActivity extends AppCompatActivity {


    private ActivityRegistionBinding binding;

    private String name, phone, address, email, password, confrimpassword;

    private FirebaseAuth auth;

    private DatabaseReference reference;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        reference = FirebaseDatabase.getInstance().getReference();

        binding.textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistionActivity.this, LoginActivity.class));

            }
        });

        binding.regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = binding.userName.getText().toString();
                phone = binding.userPhone.getText().toString();
                address = binding.userAddress.getText().toString();
                email = binding.userEmail.getText().toString();
                password = binding.userPasword.getText().toString();
                confrimpassword = binding.userConfirmPasword.getText().toString();


                if (name.isEmpty()) {
                    binding.userName.setError("Please Enter you Name");
                    binding.userName.requestFocus();
                } else if (phone.isEmpty()) {
                    binding.userPhone.setError("Please Enter you Phone Number");
                    binding.userPhone.requestFocus();
                } else if (address.isEmpty()) {
                    binding.userAddress.setError("Please Enter  your Address");
                    binding.userAddress.requestFocus();
                } else if (email.isEmpty()) {
                    binding.userEmail.setError("Please Enter your Email Address");
                    binding.userEmail.requestFocus();
                } else if (password.isEmpty()) {
                    binding.userPasword.setError("Please Enter your Password");
                    binding.userPasword.requestFocus();
                }else  if (!password.equals(confrimpassword)){
                    binding.userConfirmPasword.setError("Password not matches");
                    binding.userConfirmPasword.requestFocus();
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                uploadData();
                            }
                        }
                    });
                }


            }
        });

    }

    private void uploadData() {

        String currentUserId = auth.getCurrentUser().getUid();

        dbRef = reference.getRef().child("users").child(currentUserId);

        HashMap<String, String> user = new HashMap<>();
        user.put("name", name);
        user.put("phone", phone);
        user.put("address", address);
        user.put("email", email);
        user.put("password", password);
        user.put("userid", currentUserId);


        dbRef.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toasty.success(RegistionActivity.this, "User Creted Successful", Toasty.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistionActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(RegistionActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}