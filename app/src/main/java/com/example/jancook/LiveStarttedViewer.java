package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class LiveStarttedViewer extends AppCompatActivity {
    private VideoView liveVideoViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_startted_viewer);
        // Initialize the views
        liveVideoViewer = findViewById(R.id.live_video_viewer);

        // Set up the video view with a sample video
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        liveVideoViewer.setVideoURI(videoUri);
        liveVideoViewer.start();
    }
}