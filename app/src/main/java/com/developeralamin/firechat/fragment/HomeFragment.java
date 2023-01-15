package com.developeralamin.firechat.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.developeralamin.firechat.R;
import com.developeralamin.firechat.adapter.UserAdapter;
import com.developeralamin.firechat.databinding.FragmentHomeBinding;
import com.developeralamin.firechat.model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private DatabaseReference databaseReference, databaseNews, databaseLastNews;

    private List<UserModel> list;
    private UserAdapter adapter;

    private ArrayList<SlideModel> imageList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());


        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        databaseNews = FirebaseDatabase.getInstance().getReference("news");
        databaseLastNews = FirebaseDatabase.getInstance().getReference("lastNews");

        databaseLastNews.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String link = snapshot.getValue(String.class);
                binding.lastNews.setText(link);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        databaseNews.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String link = snapshot.getValue(String.class);
                binding.textView.setSelected(true);
                binding.textView.setText(link);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        imageList = new ArrayList<>();

        imageList.add(new SlideModel("https://images.prothomalo.com/prothomalo-bangla%2F2022-11%2F0d2410c6-0974-4239-b998-9e6af16a5b99%2F543308_01_02.jpg?rect=0%2C0%2C3360%2C1890&auto=format%2Ccompress&fmt=webp&format=webp&w=900&dpr=1.0","Bangladesh", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://images.prothomalo.com/prothomalo-bangla%2F2022-04%2Fe61763d2-1fa4-4179-a99e-29017ab850fd%2Fa6cd0d1e_f052_421c_98fd_805276369bcb.webp?rect=104%2C0%2C959%2C639&auto=format%2Ccompress&fmt=webp&format=webp&w=320&dpr=1.0","app", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://images.prothomalo.com/prothomalo-bangla%2F2021-08%2Fd475bda3-9721-4a39-b090-8326bf66c7f3%2FAedes_mosquito.jpg?auto=format%2Ccompress&format=webp&w=640&dpr=1.0", ScaleTypes.CENTER_CROP));

        binding.imageSlider.setImageList(imageList);



        list = new ArrayList<>();
        adapter = new UserAdapter(list, requireContext());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    UserModel userModel = dataSnapshot.getValue(UserModel.class);
                    list.add(userModel);

                    binding.recyclerView.setAdapter(adapter);

                    Log.d("datecheck", "onDataChange: "+ userModel.getPhone());
                    Log.d("datecheck", "onDataChange: "+ userModel.getEmail());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return binding.getRoot();
    }
}