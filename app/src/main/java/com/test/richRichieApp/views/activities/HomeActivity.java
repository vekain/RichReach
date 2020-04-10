package com.test.richRichieApp.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.test.richRichieApp.R;
import com.test.richRichieApp.helpers.adapters.ChannelListAdapter;
import com.test.richRichieApp.helpers.adapters.ChatListAdapter;
import com.test.richRichieApp.helpers.adapters.ParticipantListAdapter;
import com.test.richRichieApp.helpers.adapters.RelatedToListAdapter;
import com.test.richRichieApp.helpers.entity.ChannelEntity;
import com.test.richRichieApp.helpers.entity.ChatEntity;
import com.test.richRichieApp.helpers.entity.ParticipantEntity;
import com.test.richRichieApp.helpers.entity.RelatedToEntity;
import com.test.richRichieApp.views.fragments.ActionBottomDialogFragment;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, ActionBottomDialogFragment.ItemClickListener {

    private RecyclerView relatedList, participantsList, newChatList;

    private ArrayList<RelatedToEntity> relatedEntityArrayList;

    private ArrayList<ParticipantEntity> participantEntityArrayList;

    private ArrayList<ChatEntity> chatEntityArrayList;

    private LinearLayout categoryLayout;

    private ActionBottomDialogFragment addBottomDialogFragment;

    private TextView categoryHeading;

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relatedList = findViewById(R.id.relatedList);
        relatedList.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        relatedList.setHasFixedSize(true);

        participantsList = findViewById(R.id.participantsList);
        participantsList.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        participantsList.setHasFixedSize(true);

        newChatList = findViewById(R.id.newChatList);
        newChatList.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
        newChatList.setHasFixedSize(true);

        categoryLayout = findViewById(R.id.categoryLayout);

        categoryHeading = findViewById(R.id.categoryHeading);

        addBottomDialogFragment = ActionBottomDialogFragment.newInstance();


        addDataToRelatedToList();

        addParticipantsDataToList();

        addNewChatToList();


        categoryLayout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.categoryLayout:
                addBottomDialogFragment.show(getSupportFragmentManager(), ActionBottomDialogFragment.TAG);
                break;

            case R.id.addNewChannelButton:

                break;
        }
    }

    @Override
    public void onItemClick(View item) {
        switch (item.getId()){
            case R.id.parentLayout:
                TextView textView = item.findViewById(R.id.relatedName);
                categoryHeading.setText(textView.getText().toString().trim());
                break;
        }
    }

    private void addDataToRelatedToList(){
        relatedEntityArrayList = new ArrayList<>();

        //Api or local storage implementation here
        relatedEntityArrayList.add(new RelatedToEntity(R.drawable.ic_image_black_24dp, "Markou Pharmacists"));

        RelatedToListAdapter adapter = new RelatedToListAdapter(relatedEntityArrayList, HomeActivity.this);
        relatedList.setAdapter(adapter);
    }

    private void addParticipantsDataToList(){
        participantEntityArrayList = new ArrayList<>();

        //Api or local storage implementation here
        participantEntityArrayList.add(new ParticipantEntity(R.drawable.ic_remove_red_eye_black_24dp, "Salespeople"));
        participantEntityArrayList.add(new ParticipantEntity(R.drawable.ic_chat_black_24dp, "Marketing"));

        ParticipantListAdapter adapter = new ParticipantListAdapter(participantEntityArrayList, HomeActivity.this);
        participantsList.setAdapter(adapter);
    }

    private void addNewChatToList(){
        chatEntityArrayList = new ArrayList<>();

        //Api or local storage implementation here
        chatEntityArrayList.add(new ChatEntity("George Garcegiou", "New Action Required", "16/11/2019 10:25", "Larknos AV, Aglantzia"));

        ChatListAdapter adapter = new ChatListAdapter(chatEntityArrayList, HomeActivity.this);
        newChatList.setAdapter(adapter);
    }


}
