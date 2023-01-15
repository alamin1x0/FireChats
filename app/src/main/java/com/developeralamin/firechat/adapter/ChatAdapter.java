package com.developeralamin.firechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developeralamin.firechat.R;
import com.developeralamin.firechat.model.ChatModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private Context context;
    private List<ChatModel> list;
    String currentUser;

    final int sender = 1;
    final int receiver = 2;

    public ChatAdapter(Context context, List<ChatModel> list) {
        this.context = context;
        this.list = list;
        currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
    }

    @NonNull
    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == sender){
            View view = LayoutInflater.from(context).inflate(R.layout.sender_item_layout, parent, false);
            return new ChatViewHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.receiver_item_layout, parent, false);
            return new ChatViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatViewHolder holder, int position) {


        holder.textView.setText(list.get(position).getMessage());
        holder.dateTime.setText(list.get(position).getDatetime());
        holder.dateyears.setText(list.get(position).getYears());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView,dateTime,dateyears;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.reciverImageId);
            textView = itemView.findViewById(R.id.textMessageId);
            dateTime = itemView.findViewById(R.id.dateTime);
            dateyears = itemView.findViewById(R.id.dateyears);


        }

    }

    @Override
    public int getItemViewType(int position) {

        if (currentUser.equals(list.get(position).getSender())) {
            return sender;
        } else {
            return receiver;
        }
    }
}
