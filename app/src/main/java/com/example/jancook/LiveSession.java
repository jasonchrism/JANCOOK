package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class LiveSession extends AppCompatActivity {

    private EditText liveTitle;
    private EditText shortDescription;
    private ToggleButton topicButton1, topicButton2, topicButton3 ,topicButton4, topicButton5, topicButton6 ,topicButton7, topicButton8, topicButton9  ;
    private CheckBox agreementCheckbox;
    private Button startLiveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_session);

        // Initialize UI components
        liveTitle = findViewById(R.id.live_title);
        shortDescription = findViewById(R.id.short_description);
        topicButton1 = findViewById(R.id.topic_button_1);
        topicButton2 = findViewById(R.id.topic_button_2);
        topicButton3 = findViewById(R.id.topic_button_3);
        topicButton4 = findViewById(R.id.topic_button_4);
        topicButton5 = findViewById(R.id.topic_button_5);
        topicButton6 = findViewById(R.id.topic_button_6);
        topicButton7 = findViewById(R.id.topic_button_7);
        topicButton8 = findViewById(R.id.topic_button_8);
        topicButton9 = findViewById(R.id.topic_button_9);
        agreementCheckbox = findViewById(R.id.agreement_checkbox);
        startLiveButton = findViewById(R.id.start_live_button);

        // Set click listener for the start button
        startLiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    // Start live session logic here
                    Toast.makeText(LiveSession.this, "Live Session Started!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LiveSession.this, LiveStartedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Form validation method
    private boolean validateForm() {
        String title = liveTitle.getText().toString().trim();
        String description = shortDescription.getText().toString().trim();
        boolean isTopicSelected = topicButton1.isChecked() || topicButton2.isChecked() || topicButton3.isChecked() || topicButton4.isChecked() || topicButton5.isChecked() || topicButton6.isChecked() || topicButton7.isChecked() || topicButton8.isChecked() || topicButton9.isChecked();
        boolean isAgreementChecked = agreementCheckbox.isChecked();

        if (title.isEmpty()) {
            Toast.makeText(this, "Please enter a live title", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (description.isEmpty()) {
            Toast.makeText(this, "Please enter a short description", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!isTopicSelected) {
            Toast.makeText(this, "Please select at least one topic", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!isAgreementChecked) {
            Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
