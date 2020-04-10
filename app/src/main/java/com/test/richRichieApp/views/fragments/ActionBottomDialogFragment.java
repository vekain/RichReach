package com.test.richRichieApp.views.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.test.richRichieApp.R;
import com.test.richRichieApp.helpers.adapters.ChannelListAdapter;
import com.test.richRichieApp.helpers.entity.ChannelEntity;
import com.test.richRichieApp.views.activities.HomeActivity;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ActionBottomDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;
    private RecyclerView channelList;
    private ArrayList<ChannelEntity> channelEntityArrayList;
    private ChannelListAdapter adapter;

    public static ActionBottomDialogFragment newInstance() {
        return new ActionBottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_channel_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.addNewChannelButton).setOnClickListener(this);
        view.findViewById(R.id.closeBottomSheetButton).setOnClickListener(this);

        channelList = view.findViewById(R.id.channelList);
        channelList.setLayoutManager(new LinearLayoutManager(getContext()));
        channelList.setHasFixedSize(true);

        loadChannelCategoryList();

    }

    private void loadChannelCategoryList(){
        channelEntityArrayList = new ArrayList<>();

        //Api or local storage implementation here
        channelEntityArrayList.add(new ChannelEntity("0","Competition Info"));
        channelEntityArrayList.add(new ChannelEntity("1","Complaints"));
        channelEntityArrayList.add(new ChannelEntity("2","Market Info"));
        channelEntityArrayList.add(new ChannelEntity("3","Newsletter"));
        channelEntityArrayList.add(new ChannelEntity("4","Other"));
        channelEntityArrayList.add(new ChannelEntity("5","Sales Lead"));

         adapter = new ChannelListAdapter(channelEntityArrayList, getContext());
        channelList.setAdapter(adapter);
        adapter.setOnClick(new ChannelListAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position, View view) {
                mListener.onItemClick(view);
                dismiss();
            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.addNewChannelButton){
            showChannelAdditionDialog(getContext());
        }
        else {
            dismiss();
            mListener.onItemClick(view);
        }
    }

    public interface ItemClickListener {
        void onItemClick(View item);
    }

    private void showChannelAdditionDialog(final Context context){

        View channelAddition = LayoutInflater.from(getContext()).inflate(R.layout.add_channel_dialog_layout, null);
        AlertDialog.Builder builderChannelAddition = new AlertDialog.Builder(context);
        builderChannelAddition.setView(channelAddition);

        final AlertDialog dialogChannel = builderChannelAddition.create();
        if (dialogChannel.getWindow() != null) {
            dialogChannel.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialogChannel.setCancelable(false);

        ImageView closeDialogButton = channelAddition.findViewById(R.id.closeDialogButton);
        final TextView categoryNameTextView = channelAddition.findViewById(R.id.categoryNameTextView);
        Button addCategoryButton = channelAddition.findViewById(R.id.addCategoryButton);

        categoryNameTextView.requestFocus();

        closeDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogChannel.dismiss();
            }
        });


        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(categoryNameTextView.getText())){
                    categoryNameTextView.setError("Invalid Category Name !!");
                    categoryNameTextView.requestFocus();
                }
                else {
                    //Implement API or local Db category addition here.
                    channelEntityArrayList.add(0,new ChannelEntity("AutoId", categoryNameTextView.getText().toString().trim()));
                    adapter.notifyDataSetChanged();

                    Toast.makeText(context,"Added Successfully !!", Toast.LENGTH_SHORT).show();
                    dialogChannel.dismiss();
                }
            }
        });









        dialogChannel.show();
    }
}