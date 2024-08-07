package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.jancook.Adapter.FilledWeeklyPlannerPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class FilledWeeklyPlanner extends AppCompatActivity {
    TabLayout tlWeeklyPlanner;
    private ViewPager2 viewPager;
    private static final String[] DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private static final int[] DAY_NUMBERS = {3, 4, 5, 6, 7, 8, 9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filled_weekly_planner);

        tlWeeklyPlanner = findViewById(R.id.tlWeeklyPlanner);
        viewPager = findViewById(R.id.viewPager);

//        viewPager.setAdapter(new FilledWeeklyPlannerPagerAdapter(this));

        new TabLayoutMediator(tlWeeklyPlanner, viewPager, (tab, position) -> {
            tab.setCustomView(createTabView(position));
        }).attach();

        if (tlWeeklyPlanner.getTabAt(0) != null) {
            View view = tlWeeklyPlanner.getTabAt(0).getCustomView();
            if (view != null) {
                view.setSelected(true);
            }
        }

    }

    private View createTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.weekly_planner_tab_custom, null);
        TextView tabDayName = view.findViewById(R.id.tab_day_name);
        TextView tabDayNumber = view.findViewById(R.id.tab_day_number);
        tabDayName.setText(DAYS[position]);
        tabDayNumber.setText(String.valueOf(DAY_NUMBERS[position]));
        return view;
    }
}