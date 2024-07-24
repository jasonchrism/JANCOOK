package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        getSupportActionBar().hide();

//        inisiasi
        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateInput())
                {
                    Toast.makeText(RegisterActivity.this,   "Registration Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateInput()
    {
        String username = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

//        validasi
        if(username.isEmpty())
        {
            usernameEditText.setError("Username cannot be empty");
            return false;
        } else if (username.length() < 3) {
            usernameEditText.setError("Username cannot be less than 3");
            return false;
        }

        if(email.isEmpty())
        {
            emailEditText.setError("Email cannot be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Invalid email format");
            return false;
        }

        if(password.isEmpty())
        {
            passwordEditText.setError("Password cannot be empty");
            return false;
        } else if (password.length() < 8) {
            passwordEditText.setError("Password at least 8 characters");
            return false;
        }

        if(!password.equals(confirmPassword))
        {
            confirmPasswordEditText.setError("Password do not match");
            return false;
        }

        return true;
    }
}