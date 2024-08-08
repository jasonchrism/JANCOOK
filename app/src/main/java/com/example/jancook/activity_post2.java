package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.jancook.Adapter.IngredientAdapter;

import java.util.ArrayList;
import java.util.List;

public class activity_post2 extends AppCompatActivity {

    private RecyclerView ingredientsRecyclerView;
    private IngredientAdapter ingredientAdapter;
    private List<String> ingredientsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post2);
        ingredientsRecyclerView = findViewById(R.id.ingredientsRecyclerView);
        Button addIngredientButton = findViewById(R.id.addIngredientButton);

        ingredientAdapter = new IngredientAdapter(ingredientsList, this);
        ingredientsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ingredientsRecyclerView.setAdapter(ingredientAdapter);

        addIngredientButton.setOnClickListener(view -> {
            ingredientsList.add("");
            ingredientAdapter.notifyItemInserted(ingredientsList.size()-1);
        });

        Button previousButton = findViewById(R.id.previousButton);
        Button nextButton = findViewById(R.id.nextButton);
        ImageButton backBtn = findViewById(R.id.backBtn);

        previousButton.setOnClickListener(view -> {
            Intent intent = new Intent(activity_post2.this, PostActivity.class);
            startActivity(intent);
        });

        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(activity_post2.this, HomeActivity.class);
            startActivity(intent);
        });

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(activity_post2.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}