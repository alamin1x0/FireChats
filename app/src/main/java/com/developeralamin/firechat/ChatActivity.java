package com.developeralamin.firechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.developeralamin.firechat.adapter.ChatAdapter;
import com.developeralamin.firechat.databinding.ActivityChatBinding;
import com.developeralamin.firechat.model.ChatModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private DatabaseReference databaseReference;

    private String senderId;
    private String receiverId;

    private List<ChatModel> list;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        binding.inputName.setText(name);

        receiverId = intent.getStringExtra("userId");

        senderId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("chats");

        list = new ArrayList<>();
        adapter = new ChatAdapter(getApplicationContext(), list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setStackFromEnd(true);
        binding.messageRecylerView.setLayoutManager(layoutManager);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ChatModel chatModel = dataSnapshot.getValue(ChatModel.class);
                    if (senderId.equals(chatModel.getSender()) && receiverId.equals(chatModel.getReceiverId()) ||
                    senderId.equals(chatModel.getReceiverId()) && receiverId.equals(chatModel.getSender())){
                        list.add(chatModel);
                    }
                }

                binding.messageRecylerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mess_text = binding.messagTextId.getText().toString();
                String  chatId = databaseReference.push().getKey();

                String datetime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
                String years = new SimpleDateFormat("dd MMMM yyyy EEEE", Locale.getDefault()).format(new Date());

                HashMap<String, Object> chatMap = new HashMap<>();
                chatMap.put("sender", senderId);
                chatMap.put("receiverId", receiverId);
                chatMap.put("message", mess_text);
                chatMap.put("chatId", chatId);
                chatMap.put("datetime", datetime);
                chatMap.put("years", years);

                databaseReference.child(chatId).setValue(chatMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ChatActivity.this, "Message Send", Toast.LENGTH_SHORT).show();
                        }
                    }

                });

                binding.messagTextId.getText().clear();

            }
        });

    }
}