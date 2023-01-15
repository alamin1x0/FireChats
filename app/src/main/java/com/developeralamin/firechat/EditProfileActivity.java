package com.developeralamin.firechat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.developeralamin.firechat.databinding.ActivityEditProfileBinding;
import com.developeralamin.firechat.fragment.ProfileFragment;
import com.developeralamin.firechat.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

import es.dmoral.toasty.Toasty;

public class EditProfileActivity extends AppCompatActivity {

    private ActivityEditProfileBinding binding;

    private DatabaseReference databaseReference;

    private StorageReference storageReference;

    Uri uri;

    String profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        storageReference = FirebaseStorage.getInstance().getReference("profile_image").child(FirebaseAuth.getInstance().getCurrentUser().getUid().toString());

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    UserModel userModel = snapshot.getValue(UserModel.class);

                    binding.userName.setText(userModel.getName().toString());
                    binding.userPhone.setText(userModel.getPhone().toString());
                    binding.userAddress.setText(userModel.getAddress().toString());
                    binding.userEmail.setText(userModel.getEmail().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.userName.getText().toString();
                String phone = binding.userPhone.getText().toString();
                String address = binding.userAddress.getText().toString();
                String email = binding.userEmail.getText().toString();

                StorageReference storageRef = storageReference.child("profile" + name);

                if (uri != null) {
                    storageRef.putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {

                                storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {

                                        profileImage = String.valueOf(uri);

                                        HashMap<String, Object> user = new HashMap<>();
                                        user.put("name", name);
                                        user.put("phone", phone);
                                        user.put("address", address);
                                        user.put("email", email);
                                        user.put("profileurl", profileImage);

                                        databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toasty.success(EditProfileActivity.this, "Update Successful", Toasty.LENGTH_SHORT).show();
                                            }
                                        });


                                    }
                                });

                            }
                        }
                    });
                }
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    uri = data.getData();
                    binding.profileImage.setImageURI(uri);
                }
            }
        }
    }
}
