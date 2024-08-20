package com.example.jancook.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.jancook.MenuFragment;

public class FilledPagerAdapter extends FragmentStateAdapter {
    public FilledPagerAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return MenuFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
