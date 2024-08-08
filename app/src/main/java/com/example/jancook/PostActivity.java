package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Button nextButton = findViewById(R.id.nextButton);
        ImageButton backBtn = findViewById(R.id.backBtn);

        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(PostActivity.this, activity_post2.class);
            startActivity(intent);
        });

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(PostActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}