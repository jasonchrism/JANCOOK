package com.example.jancook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FilledWeeklyPlannerFragment extends Fragment {

    private static final String ARG_DAY_NUMBER = "day_number";

    public static FilledWeeklyPlannerFragment newInstance(int dayNumber) {
        FilledWeeklyPlannerFragment fragment = new FilledWeeklyPlannerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DAY_NUMBER, dayNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_filled_weekly_planner, container, false);
    }
}
