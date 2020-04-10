package com.test.richRichieApp.helpers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.richRichieApp.R;
import com.test.richRichieApp.helpers.entity.ChatEntity;
import com.test.richRichieApp.helpers.entity.ParticipantEntity;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder>{

    private ArrayList<ChatEntity> mRelatedToEntityArrayList;

    private Context mContext;

    public ChatListAdapter(ArrayList<ChatEntity> relatedEntityArrayList, Context context) {
        mContext = context;
        mRelatedToEntityArrayList = relatedEntityArrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_data_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.name.setText(mRelatedToEntityArrayList.get(position).getUserName());

        holder.actionTextView.setText(mRelatedToEntityArrayList.get(position).getAction());

        holder.messageDateTime.setText(mRelatedToEntityArrayList.get(position).getDateTime());

        holder.newCustomerText.setText(holder.newCustomerText.getText().toString().trim() + "\n" + mRelatedToEntityArrayList.get(position).getLocation());


    }

    @Override
    public int getItemCount() {
        return mRelatedToEntityArrayList.size();
    }


    static class Holder extends RecyclerView.ViewHolder {

        TextView name, actionTextView, messageDateTime, newCustomerText;

        Holder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.relatedName);

            actionTextView = itemView.findViewById(R.id.actionTextView);

            messageDateTime = itemView.findViewById(R.id.messageDateTime);

            newCustomerText = itemView.findViewById(R.id.newCustomerText);

        }
    }
}
