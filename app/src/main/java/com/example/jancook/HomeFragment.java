package com.example.jancook;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jancook.Adapter.StoryAdapter;
import com.example.jancook.Adapter.VPAdapter;
import com.example.jancook.Model.StoryModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private static int ADD_STORY_TYPE = 0;
    private static int ALL_STORY_TYPE = 1;

    List<StoryModel> modelList = new ArrayList<>();
    RecyclerView recyclerView;

    StoryAdapter adapter;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private boolean isLoveButtonSelected = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView searchButton = view.findViewById(R.id.btn_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        ImageView notificationBtn = view.findViewById(R.id.notificationBtn);
        notificationBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NotificationActivity.class);
            startActivity(intent);
        });

        // story
        recyclerView = view.findViewById(R.id.story_recyclerView_id);

        modelList.add(new StoryModel(ADD_STORY_TYPE, "1", R.drawable.profile2));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "2", "10", "Jason C", R.drawable.pp3));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "3", "11", "Jason C", R.drawable.pp3));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "4", "12", "Jason C", R.drawable.pp3));
        modelList.add(new StoryModel(ALL_STORY_TYPE, "5", "13", "Jason C", R.drawable.pp3));

        adapter = new StoryAdapter(modelList);
        recyclerView.setAdapter(adapter);
        adapter.notifyItemChanged();

        // tabs

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new ForYouFragment(), "For You");
        vpAdapter.addFragment(new FollowingFragment(), "Following");
        viewPager.setAdapter(vpAdapter);

        return view;
    }
}