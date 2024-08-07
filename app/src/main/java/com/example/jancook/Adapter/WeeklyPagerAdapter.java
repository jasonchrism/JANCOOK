package com.example.jancook.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.jancook.DayFragment;

public class WeeklyPagerAdapter extends FragmentStateAdapter {

    public WeeklyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return the Fragment corresponding to each day
        return DayFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 7; // Number of days in a week
    }
}
