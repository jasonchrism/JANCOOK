package com.example.jancook;

import android.os.Bundle;

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
                    selectedFragment = new WeekPlannerFragment();
                    break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.post:
                    selectedFragment = new PostFragment();
                    break;
            }
            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }
            return true;
        });

        binding.post.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new PostFragment()); // Make sure to use the correct container ID
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
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
