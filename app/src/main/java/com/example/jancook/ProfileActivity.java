package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.material.tabs.TabLayout;
import androidx.core.content.ContextCompat;

public class ProfileActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabPagerAdapter tabPagerAdapter;

    // Icons for the tabs
    int[] tabIcons = {
            R.drawable.myfeed,  // Replace with your actual vector drawable resource
            R.drawable.myliked, // Replace with your actual vector drawable resource
            R.drawable.mykeep   // Replace with your actual vector drawable resource
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        // Set custom views for the tabs
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(getTabView(i, i == tabLayout.getSelectedTabPosition())); // Check if it's the selected tab
            }
        }

        // Add tab selection listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTabIcon(tab, true); // true for selected state
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabIcon(tab, false); // false for unselected state
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // No action needed
            }
        });

        //share profile
        Button shareProfileButton = findViewById(R.id.button_share_profile);
        shareProfileButton.setOnClickListener(v -> {
            ShareProfileBottomSheet bottomSheet = new ShareProfileBottomSheet();
            bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
        });

        //edit profile
        Button editProfileButton = findViewById(R.id.button_edit_profile);
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, editProfile.class);
            startActivity(intent);
        });
    }

    private View getTabView(int position, boolean isSelected) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_icon, null);
        ImageView icon = view.findViewById(R.id.tab_icon);
        icon.setImageResource(tabIcons[position]);
        int color = isSelected ? R.color.primary_red : R.color.black2; // Define these colors in colors.xml
        icon.setColorFilter(ContextCompat.getColor(this, color), android.graphics.PorterDuff.Mode.SRC_IN);
        return view;
    }

    private void updateTabIcon(TabLayout.Tab tab, boolean isSelected) {
        if (tab.getCustomView() != null) {
            ImageView icon = tab.getCustomView().findViewById(R.id.tab_icon);
            int color = isSelected ? R.color.primary_red : R.color.black2; // Define these colors in colors.xml
            icon.setColorFilter(ContextCompat.getColor(this, color), android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }
}
