package com.example.jancook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class post3 extends AppCompatActivity {

    private List<String> stepDescriptions;
    private RecipeStepAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post3);

        // Initialize the RecyclerView
        RecyclerView recipeStepsRecyclerView = findViewById(R.id.recipeStepsRecyclerView);
        Button addStepButton = findViewById(R.id.addStepButton);

        // Start with an empty list
        stepDescriptions = new ArrayList<>();

        // Setup adapter and RecyclerView
        adapter = new RecipeStepAdapter(this, stepDescriptions);
        recipeStepsRecyclerView.setAdapter(adapter);
        recipeStepsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Handle adding steps
        addStepButton.setOnClickListener(v -> {
            stepDescriptions.add("A vibrant mix of fresh greens, crisp vegetables, and savory toppings...");
            adapter.notifyItemInserted(stepDescriptions.size() - 1);
        });

        // Enable drag-and-drop functionality
        ItemTouchHelper.Callback callback = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                return makeMovementFlags(dragFlags, 0);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // No swipe action needed
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return false;
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recipeStepsRecyclerView);

        // Handle navigation buttons
        Button previousButton = findViewById(R.id.previousButton);
        Button nextButton = findViewById(R.id.nextButton);
        ImageButton backBtn = findViewById(R.id.backBtn);

        previousButton.setOnClickListener(view -> {
            Intent intent = new Intent(post3.this, activity_post2.class);
            startActivity(intent);
        });

        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(post3.this, HomeActivity.class);
            startActivity(intent);
        });

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(post3.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
