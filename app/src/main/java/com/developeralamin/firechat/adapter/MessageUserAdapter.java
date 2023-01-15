package com.developeralamin.firechat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developeralamin.firechat.R;
import com.developeralamin.firechat.model.UserModel;

import java.util.List;

public class MessageUserAdapter extends RecyclerView.Adapter<MessageUserAdapter.MessageViewHolder>{


    private List<UserModel> list;
    private Context context;




    @NonNull
    @Override
    public MessageUserAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageUserAdapter.MessageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView, inputName, inputEmail;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profile_image);
            inputName = itemView.findViewById(R.id.inputName);
            inputEmail = itemView.findViewById(R.id.inputEmail);

        }
    }
}
