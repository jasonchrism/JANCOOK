package com.example.jancook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LiveStartedActivity extends AppCompatActivity {

    private VideoView liveVideoView;
    private Button stopLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_started);

        // Initialize the views
        liveVideoView = findViewById(R.id.live_video_view);

        // Set up the video view with a sample video
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        liveVideoView.setVideoURI(videoUri);
        liveVideoView.start();

        stopLive = findViewById(R.id.end_button);

        // Set click listener for the start button
        stopLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Start live session logic here
                    Toast.makeText(LiveStartedActivity.this, "Live Session ended!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LiveStartedActivity.this, HomeActivity.class);
                    startActivity(intent);

            }
        });

    }
}