package com.example.jancook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.jancook.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setBackground(null);


        // Initial fragment
        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
        }

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            boolean addToBackStack = true;
            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new HomeFragment();
//                    addToBackStack = false;
                    break;
                case R.id.dictionary:
                    selectedFragment = new DictionaryFragment();
                    break;
                case R.id.weekly_planner:
                    selectedFragment = new FilledWeeklyPlannerFragment();
                    break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.post:
//                    selectedFragment = new PostFragment();
                    return true;
            }
            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }
            return true;
        });

        binding.post.setOnClickListener(v -> {
            Intent i = new Intent(HomeActivity.this, PostActivity.class);
            startActivity(i);
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
