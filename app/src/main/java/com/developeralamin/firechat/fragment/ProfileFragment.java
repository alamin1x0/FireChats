package com.developeralamin.firechat.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.developeralamin.firechat.EditProfileActivity;
import com.developeralamin.firechat.LoginActivity;
import com.developeralamin.firechat.R;
import com.developeralamin.firechat.databinding.FragmentProfileBinding;
import com.developeralamin.firechat.model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {


    private FragmentProfileBinding binding;

    private DatabaseReference databaseReference;
    private FirebaseAuth auth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();


        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    UserModel userModel = snapshot.getValue(UserModel.class);

                    binding.userName.setText("Name: " + userModel.getName().toString());
                    binding.userPhone.setText("Phone: " + userModel.getPhone().toString());
                    binding.userAddress.setText("Address: " + userModel.getAddress().toString());
                    binding.userEmail.setText("Email:  " + userModel.getEmail().toString());

                    Glide.with(getActivity()).load(userModel.getProfileurl()).placeholder(R.drawable.profile).into(binding.profileImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        binding.editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
            }
        });


        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.signOut();
                startActivity(new Intent(getActivity(), LoginActivity.class));


            }
        });

        return binding.getRoot();
    }
}