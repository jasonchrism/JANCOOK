package com.example.jancook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        ini untuk hide action bar bawaan yang tulisannya ada "JANCOOK"-nya
//        getSupportActionBar().hide();

//        inisiasi views
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        TextView registerTextView = findViewById(R.id.registerTextView);

//        ini untuk tombol sign in
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (validateAndSignIn())
               {
                   Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                   Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                   startActivity(intent);
                   finish();
               }
            }
        });

//        ini untuk sign in words aja
        String registerText = "Don't have an account? Sign Up";
        SpannableString spannableString = new SpannableString(registerText);

//        ini untuk bikin cuman text sign up yang bisa di click
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        };

        int startIndex = registerText.indexOf("Sign Up");
        int endIndex = startIndex + "Sign Up".length();

//        ini untuk edit text sign up aja, bikin style jadi bold, white, dan underlined
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        ini untuk applied apa yang udah dikasih dari bagian di atas ini
        registerTextView.setText(spannableString);
        registerTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private boolean validateAndSignIn()
    {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

//        ini untuk validasi username
        if(TextUtils.isEmpty(username))
        {
            usernameEditText.setError("Username cannot be empty");
            return false;
        } else if (username.length()<3) {
            usernameEditText.setError("Username must be at least 3 characters");
            return false;
        }

//        ini untuk validasi password
        if(TextUtils.isEmpty(password))
        {
            passwordEditText.setError("Password cannot be empty");
            return false;
        }

//        ini setelah validasi sudah oke, kan akan di click. Nanti kalau lewat validasinya
//        langsung buka home, tapi nanti yang kerjain home boleh ganti aja
        return true;
    }
}