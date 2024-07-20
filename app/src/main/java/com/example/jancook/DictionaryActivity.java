package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DictionaryActivity extends AppCompatActivity {

    GridView gridView;

    String[] names = {"Garlic", "Shallot", "Broccoli", "Tomato", "Cucumber", "Carrot", "Pumpkin", "Spinach", "Eggplant", "Jackfuit"};
    String[] prices = {"Rp51450/kg", "Rp21000/kg", "Rp26000/kg", "Rp48000/kg", "Rp37000/kg", "Rp18000/kg", "Rp20000/kg", "Rp24000/kg", "Rp35000/kg", "Rp40000/kg"};
    String[] categories = {"Vegetables", "Vegetables", "Vegetables", "Fruits", "Fruits", "Vegetables", "Fruits", "Vegetables", "Fruits", "Vegetables"};
    String[] informations = {"72 cal/100gr", "149 cal/100gr", "34 cal/100gr", "19 cal/100gr", "41 cal/100gr", "26 cal/100gr", "23 cal/100gr", "33 cal/100gr", "25 cal/100gr", "94 cal/100gr"};
    int[] images = {R.drawable.garlic, R.drawable.shallot, R.drawable.broccoli, R.drawable.tomato, R.drawable.cucumber, R.drawable.carrot, R.drawable.pumpkin, R.drawable.spinach, R.drawable.eggplant, R.drawable.jackfruit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        getSupportActionBar().hide();

        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(names, images, prices, categories, informations, this);

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = names[position];
                int selectedImage = images[position];
                String selectedPrice = prices[position];
                String selectedCategory = categories[position];
                String selectedInformation = informations[position];

                startActivity(new Intent(DictionaryActivity.this, ingredient_detailActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage).putExtra("price", selectedPrice).putExtra("category", selectedCategory).putExtra("information", selectedInformation));
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        private String[] imageName;
        private int[] imagesPhoto;
        private String[] imagesPrice;
        private  String[] imagesCategory;
        private String[] imagesInformation;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageName, int[] imagesPhoto, String[] imagesPrice, String[] imagesCategory, String[] imagesInformation, Context context) {
            this.imageName = imageName;
            this.imagesPhoto = imagesPhoto;
            this.imagesPrice = imagesPrice;
            this.imagesCategory = imagesCategory;
            this.imagesInformation = imagesInformation;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = layoutInflater.inflate(R.layout.card_item, viewGroup, false);
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
}