package com.example.jancook;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ProfileActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FeedsGridAdapter gridAdapter;
    private List<Integer> imageList = Arrays.asList(
            R.drawable.food12, R.drawable.food10, R.drawable.food3, // Add your images here
            R.drawable.food6, R.drawable.food15, R.drawable.food4,
            R.drawable.food15, R.drawable.food2, R.drawable.food5
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        recyclerView = findViewById(R.id.recyclerView);

        int numberOfColumns = 3; // Set the number of columns for the grid
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        int columnWidth = getScreenWidth() / numberOfColumns; // Calculate the column width based on screen width
        gridAdapter = new FeedsGridAdapter(this, imageList, columnWidth);
        recyclerView.setAdapter(gridAdapter);
    }

    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        return display.getWidth(); // Get the screen width in pixels
    }
}
