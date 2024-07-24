package com.example.jancook;

import android.content.Context;
import android.widget.GridView;

public class GridViewDictionaryUtils {
    public static void setupGridView(GridView gridView, Context context, String[] names, int[] images, String[] prices, String[] categories, String[] informations, String[] explanations) {
        CustomAdapter customAdapter = new CustomAdapter(names, images, prices, categories, informations, explanations, context);
        gridView.setAdapter(customAdapter);
    }
}
