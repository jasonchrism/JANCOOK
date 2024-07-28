package com.example.jancook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private String[] imageName;
    private int[] imagesPhoto;
    private String[] imagesPrice;
    private String[] imagesCategory;
    private String[] imagesInformation;
    private String[] imagesExplanation;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(String[] imageName, int[] imagesPhoto, String[] imagesPrice, String[] imagesCategory, String[] imagesInformation, String[] imagesExplanation, Context context) {
        this.imageName = imageName;
        this.imagesPhoto = imagesPhoto;
        this.imagesPrice = imagesPrice;
        this.imagesCategory = imagesCategory;
        this.imagesInformation = imagesInformation;
        this.imagesExplanation = imagesExplanation;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageName.length;
    }

    @Override
    public Object getItem(int position) {
        return imageName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.card_item, parent, false);
        }

        TextView tvName = view.findViewById(R.id.tvName);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        TextView tvCategory = view.findViewById(R.id.tvCategory);
        TextView tvInformation = view.findViewById(R.id.tvInfo);

        tvName.setText(imageName[position]);
        imageView.setImageResource(imagesPhoto[position]);
        tvPrice.setText(imagesPrice[position]);
        tvCategory.setText(imagesCategory[position]);
        tvInformation.setText(imagesInformation[position]);

        return view;
    }
}
