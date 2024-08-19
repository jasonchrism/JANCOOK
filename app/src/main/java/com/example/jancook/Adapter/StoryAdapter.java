package com.example.jancook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jancook.LiveSession;
import com.example.jancook.LiveStartedActivity;
import com.example.jancook.LiveStarttedViewer;
import com.example.jancook.Model.StoryModel;
import com.example.jancook.R;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    List<StoryModel> modelList;
    private static int ADD_STORY_TYPE = 0;
    private static int ALL_STORY_TYPE = 1;

    public StoryAdapter(List<StoryModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == ADD_STORY_TYPE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item_live, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {

        StoryModel model = modelList.get(position);
        int viewType = getItemViewType(position);
        if(viewType == ADD_STORY_TYPE){
            String uid = model.getUid();
            int image = model.getImage();
            holder.setLiveStory(uid, image);
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), LiveSession.class);
                v.getContext().startActivity(intent);
            });
        }else{
            String uid = model.getUid();
            String sid = model.getSid();
            String name = model.getName();
            int image = model.getImage();
            holder.setStory(uid, sid, name, image);
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), LiveStarttedViewer.class);
                v.getContext().startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) return 0;
        else return 1;
    }

    public void notifyItemChanged() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView username;
        ImageView profileImg;
        FrameLayout startLive;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username_id);
            profileImg = itemView.findViewById(R.id.userProfile_id);

            profileImg.setOnClickListener(v -> {
                int position = getAdapterPosition();
                int viewType = getItemViewType();

                if (viewType == ADD_STORY_TYPE) {
                    // Redirect to ActivityA (LiveSession)
                    Intent intent = new Intent(v.getContext(), LiveSession.class);
                    v.getContext().startActivity(intent);
                } else if (viewType == ALL_STORY_TYPE) {
                    // Redirect to ActivityB (LiveStarttedViewer)
                    Intent intent = new Intent(v.getContext(), LiveStarttedViewer.class);
                    v.getContext().startActivity(intent);
                }
            });

        }

        public void setLiveStory(String uid, int image) {
            username.setText("Go Live");
            profileImg.setImageResource(image);
        }

        public void setStory(String uid, String sid, String name, int image) {
            username.setText(name);
            profileImg.setImageResource(image);
        }
    }
}
