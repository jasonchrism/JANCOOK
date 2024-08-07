package com.example.jancook;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link myKeep#newInstance} factory method to
 * create an instance of this fragment.
 */
public class myKeep extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public myKeep() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment myKeep.
     */
    // TODO: Rename and change types and number of parameters
    public static myKeep newInstance(String param1, String param2) {
        myKeep fragment = new myKeep();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_keep, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns)); // 3 columns

        int columnWidth = getScreenWidth() / numberOfColumns;
        gridAdapter = new FeedsGridAdapter(getContext(), imageList, columnWidth);
        recyclerView.setAdapter(gridAdapter);

        return view;
    }

    private RecyclerView recyclerView;
    private FeedsGridAdapter gridAdapter;
    private List<Integer> imageList = Arrays.asList(
            R.drawable.food11, R.drawable.food12, R.drawable.food13, // Add your images here
            R.drawable.food10, R.drawable.food15, R.drawable.food5,
            R.drawable.food2, R.drawable.food18, R.drawable.food4
    );

    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        return display.getWidth();
    }
}