package com.example.jancook.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.jancook.FilledWeeklyPlannerFragment;

public class FilledWeeklyPlannerPagerAdapter extends FragmentStateAdapter {
    public FilledWeeklyPlannerPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FilledWeeklyPlannerFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
