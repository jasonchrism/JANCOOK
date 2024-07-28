package com.example.jancook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.jancook.Model.FeedModel;
import com.example.jancook.R;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    List<FeedModel> modelList;

    public FeedAdapter(List<FeedModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FeedModel model = modelList.get(position);
        ArrayList<SlideModel> feedImages = model.getFeedImages();
        int profileImage = model.getProfileImage();
        int duration = model.getDuration();
        int portion = model.getPortion();
        int loveCount = model.getLoveCount();
        int commentCount = model.getCommentCount();
        String username = model.getUsername();
        String title = model.getTitle();
        String description = model.getDescription();
        String timePost = model.getTimePost();

        holder.setItems(feedImages, profileImage, duration, portion, loveCount, commentCount,username, title, description, timePost);
        
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView profileImageId;
        TextView durationId, portionId, loveCountId, commentCountId, usernameId, titleId, descriptionId, timePostId;

        ImageSlider feedImageId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageId = itemView.findViewById(R.id.profileImage);
            feedImageId = itemView.findViewById(R.id.imageSlider);
            durationId = itemView.findViewById(R.id.duration);
            portionId = itemView.findViewById(R.id.portion);
            loveCountId = itemView.findViewById(R.id.loveCount);
            commentCountId = itemView.findViewById(R.id.commentCount);
            usernameId = itemView.findViewById(R.id.username);
            titleId = itemView.findViewById(R.id.feedTitle);
            descriptionId = itemView.findViewById(R.id.feedDesc);
            timePostId = itemView.findViewById(R.id.timePost);
        }

        public void setItems(ArrayList<SlideModel> feedImages, int profileImage, int duration, int portion, int loveCount, int commentCount, String username, String title, String description, String timePost) {

            usernameId.setText(username.trim());
            durationId.setText(String.valueOf(duration) + " minutes");
            portionId.setText(String.valueOf(portion) + " persons");
            loveCountId.setText(String.valueOf(loveCount));
            commentCountId.setText(String.valueOf(commentCount));
            timePostId.setText(timePost.trim());
            profileImageId.setImageResource(profileImage);
            feedImageId.setImageList(feedImages);

        }
    }
}
