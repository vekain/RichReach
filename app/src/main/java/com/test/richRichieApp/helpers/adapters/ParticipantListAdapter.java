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
import com.test.richRichieApp.helpers.entity.ParticipantEntity;
import com.test.richRichieApp.helpers.entity.RelatedToEntity;

import java.util.ArrayList;

public class ParticipantListAdapter extends RecyclerView.Adapter<ParticipantListAdapter.Holder>{

    private ArrayList<ParticipantEntity> mRelatedToEntityArrayList;

    private Context mContext;

    public ParticipantListAdapter(ArrayList<ParticipantEntity> relatedEntityArrayList, Context context) {
        mContext = context;
        mRelatedToEntityArrayList = relatedEntityArrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.participant_data_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.name.setText(mRelatedToEntityArrayList.get(position).getName());

        holder.image.setImageDrawable(mContext.getResources().getDrawable(mRelatedToEntityArrayList.get(position).getAccessRightsImage()));

    }

    @Override
    public int getItemCount() {
        return mRelatedToEntityArrayList.size();
    }


    static class Holder extends RecyclerView.ViewHolder {

        TextView name;

        ImageView image;

        Holder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.relatedImage);

            name = itemView.findViewById(R.id.relatedName);

        }
    }
}
