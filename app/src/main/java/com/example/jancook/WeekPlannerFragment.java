package com.example.jancook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jancook.Adapter.FilledWeeklyPlannerPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeekPlannerFragment extends Fragment {

    TabLayout tlWeeklyPlanner;
    private ViewPager2 viewPager;
    private static final String[] DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private static final int[] DAY_NUMBERS = {3, 4, 5, 6, 7, 8, 9};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_week_planner, container, false);

        tlWeeklyPlanner = view.findViewById(R.id.tlWeeklyPlanner);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new FilledWeeklyPlannerPagerAdapter(this));

        new TabLayoutMediator(tlWeeklyPlanner, viewPager, (tab, position) -> {
            tab.setCustomView(createTabView(position));
        }).attach();

        if (tlWeeklyPlanner.getTabAt(0) != null) {
            View view1 = tlWeeklyPlanner.getTabAt(0).getCustomView();
            if (view1 != null) {
                view1.setSelected(true);
            }
        }
        return view;
    }

    private View createTabView(int position) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.weekly_planner_tab_custom, null);
        TextView tabDayName = view.findViewById(R.id.tab_day_name);
        TextView tabDayNumber = view.findViewById(R.id.tab_day_number);
        tabDayName.setText(DAYS[position]);
        tabDayNumber.setText(String.valueOf(DAY_NUMBERS[position]));
        return view;
    }
}