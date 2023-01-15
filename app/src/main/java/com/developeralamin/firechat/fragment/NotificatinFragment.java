package com.developeralamin.firechat.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developeralamin.firechat.R;
import com.developeralamin.firechat.adapter.TestAdapter;
import com.developeralamin.firechat.databinding.FragmentNotificatinBinding;
import com.developeralamin.firechat.model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class NotificatinFragment extends Fragment {

    private FragmentNotificatinBinding binding;

    private List<UserModel> list;

    private TestAdapter adapter;

    private DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificatinBinding.inflate(getLayoutInflater());

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        getInformation();

        list = new ArrayList<>();

        return  binding.getRoot();


    }

    private void getInformation() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserModel userData = dataSnapshot.getValue(UserModel.class);
                    list.add(userData);

                    adapter = new TestAdapter(list, getContext());
                    binding.userRecylerView.setAdapter(adapter);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}