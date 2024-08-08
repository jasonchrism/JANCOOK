    package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

    public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> onBackPressed());
    }
}