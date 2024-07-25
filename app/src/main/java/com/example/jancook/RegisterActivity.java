package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
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
        TextView loginTextView = findViewById(R.id.loginTextView);

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

        //        ini untuk sign in words aja
        String loginText = "Already have an account? Sign In";
        SpannableString spannableString = new SpannableString(loginText);

//        ini untuk bikin cuman text sign up yang bisa di click
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        };

        int startIndex = loginText.indexOf("Sign In");
        int endIndex = startIndex + "Sign In".length();

//        ini untuk edit text sign up aja, bikin style jadi bold, white, dan underlined
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        ini untuk applied apa yang udah dikasih dari bagian di atas ini
        loginTextView.setText(spannableString);
        loginTextView.setMovementMethod(LinkMovementMethod.getInstance());
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