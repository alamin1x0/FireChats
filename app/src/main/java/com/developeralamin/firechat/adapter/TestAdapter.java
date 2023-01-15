package com.developeralamin.firechat.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.developeralamin.firechat.ChatActivity;
import com.developeralamin.firechat.R;
import com.developeralamin.firechat.model.UserModel;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private List<UserModel> list;
    private Context context;

    public TestAdapter(List<UserModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TestAdapter.TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_item_layout, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.TestViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.inputName.setText(list.get(position).getName());
        holder.inputEmail.setText(list.get(position).getEmail());

        Glide.with(context).load(list.get(position).getProfileurl()).placeholder(R.drawable.profile).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("name", list.get(position).getName());
                intent.putExtra("userId", list.get(position).getUserid());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {

        private TextView inputName, inputEmail;
        private ImageView imageView;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);

            inputName = itemView.findViewById(R.id.inputName);
            inputEmail = itemView.findViewById(R.id.inputEmail);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
