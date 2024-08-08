package com.example.jancook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.jancook.Adapter.FeedAdapter;
import com.example.jancook.Model.FeedModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForYouFragment extends Fragment {

    List<FeedModel> feedModelList = new ArrayList<>();
    FeedAdapter feedAdapter;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_for_you, container, false);
        // feeds
        recyclerView = view.findViewById(R.id.feed_recyclerView_id);

        feedModelList.add(new FeedModel(R.drawable.profile2, 30, 4, 120, 50, "John Doe", "Salad Beef Crunchy", "A vibrant mix of fresh greens, crisp vegetables, and savory toppings, creating a healthy, flavorful, and satisfying dish for any meal  a salad offers a delightful burst of ...", "10 hours ago", new ArrayList<SlideModel>(Arrays.asList(new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP)))));
        feedModelList.add(new FeedModel(R.drawable.profile2, 30, 4, 120, 50, "John Doe", "Salad Beef Crunchy", "A vibrant mix of fresh greens, crisp vegetables, and savory toppings, creating a healthy, flavorful, and satisfying dish for any meal  a salad offers a delightful burst of ...", "10 hours ago", new ArrayList<SlideModel>(Arrays.asList(new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP)))));
        feedModelList.add(new FeedModel(R.drawable.profile2, 30, 4, 120, 50, "John Doe", "Salad Beef Crunchy", "A vibrant mix of fresh greens, crisp vegetables, and savory toppings, creating a healthy, flavorful, and satisfying dish for any meal  a salad offers a delightful burst of ...", "10 hours ago", new ArrayList<SlideModel>(Arrays.asList(new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP)))));
        feedModelList.add(new FeedModel(R.drawable.profile2, 30, 4, 120, 50, "John Doe", "Salad Beef Crunchy", "A vibrant mix of fresh greens, crisp vegetables, and savory toppings, creating a healthy, flavorful, and satisfying dish for any meal  a salad offers a delightful burst of ...", "10 hours ago", new ArrayList<SlideModel>(Arrays.asList(new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP), new SlideModel(R.drawable.food1, ScaleTypes.CENTER_CROP)))));

        feedAdapter = new FeedAdapter(getContext(), feedModelList);
        recyclerView.setAdapter(feedAdapter);
//        feedAdapter.notifyDataSetChanged();


        return view;
    }
}