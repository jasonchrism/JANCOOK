package com.example.jancook.Adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.jancook.HomeFragment;
import com.example.jancook.Model.FeedModel;
import com.example.jancook.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private List<FeedModel> modelList;
    private Context context;

    public FeedAdapter(Context context, List<FeedModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
        ImageButton commentBtn = view.findViewById(R.id.commentBtn);
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(parent.getContext(), R.style.BottomSheetTheme);
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_layout_sheet, null);
                bottomSheetDialog.setContentView(view1);
                bottomSheetDialog.show();
            }
        });

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

        holder.setItems(feedImages, profileImage, duration, portion, loveCount, commentCount, username, title, description, timePost);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImageId;
        TextView durationId, portionId, loveCountId, commentCountId, usernameId, titleId, descriptionId, timePostId;
        ImageButton loveBtn, bookmarkBtn;
        ImageSlider feedImageId;

        private boolean isLoveButtonSelected = false;
        private boolean isBookmarkButtonSelected = false;

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
            loveBtn = itemView.findViewById(R.id.loveBtn);
            bookmarkBtn = itemView.findViewById(R.id.bookmarkBtn);

            loveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isLoveButtonSelected = !isLoveButtonSelected;
                    loveBtn.setSelected(isLoveButtonSelected);

                    if (isLoveButtonSelected) {
                        // Use the selected drawable
                        loveBtn.setImageResource(R.drawable.love_icon_selected);
                        loveCountId.setTextColor(ContextCompat.getColor(context, R.color.love_fill_color_selected));
                    } else {
                        // Use the unselected drawable
                        loveBtn.setImageResource(R.drawable.love_icon_unselected);
                        loveCountId.setTextColor(ContextCompat.getColor(context, R.color.grey));
                    }
                }
            });

            bookmarkBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isBookmarkButtonSelected = !isBookmarkButtonSelected;
                    bookmarkBtn.setSelected(isBookmarkButtonSelected);

                    if(isBookmarkButtonSelected){
                        bookmarkBtn.setImageResource(R.drawable.bookmark_icon_selected);
                    }else{
                        bookmarkBtn.setImageResource(R.drawable.bookmark_icon_unselected);
                    }
                }
            });


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
