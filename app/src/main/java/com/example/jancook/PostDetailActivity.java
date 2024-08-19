package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Arrays;

public class PostDetailActivity extends AppCompatActivity {

    ArrayList<SlideModel> feedImages = new ArrayList<>();
    ImageButton loveBtn, bookmarkBtn, commentBtn;
    private boolean isLoveButtonSelected = false;
    private boolean isBookmarkButtonSelected = false;
    private boolean isFollowButtonSelected = false;
    ImageView backBtn;
    Button followBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        // Retrieve the data from the intent
        int profileImage = getIntent().getIntExtra("profileImage", 0);
        int duration = getIntent().getIntExtra("duration", 0);
        int portion = getIntent().getIntExtra("portion", 0);
        int loveCount = getIntent().getIntExtra("loveCount", 0);
        int commentCount = getIntent().getIntExtra("commentCount", 0);
        String username = getIntent().getStringExtra("username");
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String timePost = getIntent().getStringExtra("timePost");

        feedImages.add(new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP));
        feedImages.add(new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP));
        feedImages.add(new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP));

        // Now you can use these variables to set up your UI components
        ImageView profileImageView = findViewById(R.id.profileImage);
        TextView durationTextView = findViewById(R.id.durationTextView);
        TextView portionTextView = findViewById(R.id.portionTextView);
        TextView loveCountTextView = findViewById(R.id.loveCount);
        TextView commentCountTextView = findViewById(R.id.commentCount);
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView timePostTextView = findViewById(R.id.timePostTextView);
        ImageSlider feedImageSlider = findViewById(R.id.imageSlider);
//
        profileImageView.setImageResource(profileImage);
        durationTextView.setText(String.valueOf(duration) + " minutes");
        portionTextView.setText(String.valueOf(portion) + " persons");
        loveCountTextView.setText(String.valueOf(loveCount));
        commentCountTextView.setText(String.valueOf(commentCount));
        usernameTextView.setText(username);
        titleTextView.setText(title);
        timePostTextView.setText(timePost);
        feedImageSlider.setImageList(feedImages);

        loveBtn = findViewById(R.id.loveBtn);

        loveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLoveButtonSelected = !isLoveButtonSelected;
                loveBtn.setSelected(isLoveButtonSelected);

                if (isLoveButtonSelected) {
                    // Use the selected drawable
                    loveBtn.setImageResource(R.drawable.love_icon_selected);
                    loveCountTextView.setTextColor(ContextCompat.getColor(PostDetailActivity.this, R.color.love_fill_color_selected));
                } else {
                    // Use the unselected drawable
                    loveBtn.setImageResource(R.drawable.love_icon_unselected);
                    loveCountTextView.setTextColor(ContextCompat.getColor(PostDetailActivity.this, R.color.grey));
                }
            }
        });

        bookmarkBtn = findViewById(R.id.bookmarkBtn);
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

        commentBtn = findViewById(R.id.commentBtn);
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PostDetailActivity.this, R.style.BottomSheetTheme);
                View view2 = LayoutInflater.from(PostDetailActivity.this).inflate(R.layout.comment_layout_sheet, null);
                bottomSheetDialog.setContentView(view2);
                bottomSheetDialog.show();
            }
        });

        followBtn = findViewById(R.id.followButton);
        FrameLayout buttonContainer = findViewById(R.id.buttonContainer);
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFollowButtonSelected = !isFollowButtonSelected;

                if (isFollowButtonSelected) {
                    buttonContainer.setBackgroundResource(R.drawable.rounded_button_followed); // Change FrameLayout background
                    followBtn.setText("Followed");
                } else {
                    buttonContainer.setBackgroundResource(R.drawable.rounded_button); // Reset to original background
                    followBtn.setText("Follow");
                }
            }
        });
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}