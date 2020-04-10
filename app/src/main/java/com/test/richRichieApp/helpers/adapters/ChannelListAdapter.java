package com.test.richRichieApp.helpers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.richRichieApp.R;
import com.test.richRichieApp.helpers.entity.ChannelEntity;
import com.test.richRichieApp.helpers.entity.ChatEntity;

import java.util.ArrayList;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.Holder>{

    private ArrayList<ChannelEntity> mRelatedToEntityArrayList;

    private Context mContext;

    private OnItemClicked onClick;

    public ChannelListAdapter(ArrayList<ChannelEntity> relatedEntityArrayList, Context context) {
        mContext = context;
        mRelatedToEntityArrayList = relatedEntityArrayList;
    }

    public interface OnItemClicked {
        void onItemClick(int position, View v);
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel_data_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {

        holder.name.setText(mRelatedToEntityArrayList.get(position).getChannelName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position, v);
            }
        });

//        if (holder.getAdapterPosition() == mRelatedToEntityArrayList.size()-1){
//            holder.separatorView.setVisibility(View.GONE);
//        }

    }

    @Override
    public int getItemCount() {
        return mRelatedToEntityArrayList.size();
    }

    public void setOnClick(OnItemClicked onClick) {
        this.onClick=onClick;
    }

    static class Holder extends RecyclerView.ViewHolder {

        TextView name;

        View separatorView;

        LinearLayout parentLayout;

        Holder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.relatedName);

            separatorView = itemView.findViewById(R.id.separatorView);

            parentLayout = itemView.findViewById(R.id.parentLayout);

        }
    }
}
