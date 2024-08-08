package com.example.jancook;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class editProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> onBackPressed());

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> {
            finish();
        });

    }
}
