package com.example.jancook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ingredient_detailActivity extends AppCompatActivity {

    GridView gridView;

    String[] names = {"Garlic", "Shallot", "Broccoli", "Tomato", "Cucumber", "Carrot", "Pumpkin", "Spinach", "Eggplant", "Jackfuit"};
    String[] prices = {"Rp51450/kg", "Rp21000/kg", "Rp26000/kg", "Rp48000/kg", "Rp37000/kg", "Rp18000/kg", "Rp20000/kg", "Rp24000/kg", "Rp35000/kg", "Rp40000/kg"};
    String[] categories = {"Vegetables", "Vegetables", "Vegetables", "Fruits", "Fruits", "Vegetables", "Fruits", "Vegetables", "Fruits", "Vegetables"};
    String[] informations = {"72 cal/100gr", "149 cal/100gr", "34 cal/100gr", "19 cal/100gr", "41 cal/100gr", "26 cal/100gr", "23 cal/100gr", "33 cal/100gr", "25 cal/100gr", "94 cal/100gr"};
    String[] explanations = {
            "Garlic has a strong, spicy, and slightly sweet taste. When cooked, the taste becomes softer and sweeter. Raw garlic has a sharp, distinctive aroma, which can become milder and sweeter when cooked.",
            "Shallots have a sweeter and more subtle taste than onions. When cooked, the taste becomes softer and sweeter. Shallots have a soft and sweet aroma, not as strong as garlic or onions.",
            "Broccoli has a slightly sweet taste with a hint of bitterness, especially in the stems. Broccoli is often used in stir-fries, soups, salads, and baked dishes. Can be eaten raw or cooked.",
            "Tomatoes have a sweet and slightly sour taste. Used in salads, sauces, soups, pasta and juices. Tomatoes can also be eaten raw or cooked.",
            "Cucumbers have a fresh and slightly sweet taste. It is usually eaten raw in salads, pickled, or as a garnish. Can also be used in juices or as a drink mix.",
            "Carrots have a sweet and crunchy taste. It can be eaten raw as a snack or in salads, as well as cooked in soups, stir-fries and roasted.",
            "Pumpkin has a mild sweet taste and soft texture when cooked. Used in soups, purees, roasts, and as a pie filling. Pumpkin is also used in some sweet dishes.",
            "Spinach has a slightly sweet and mild taste, with a slight bitterness in older leaves.  It can be eaten raw in salads or cooked in soups, stir-fries, quiches and baked dishes.",
            "Eggplant has a mild, slightly bitter taste, with a spongy texture that can absorb the flavors of spices and sauces. Often used in grilled dishes, stir-fries, curries, and Mediterranean dishes such as moussaka and ratatouille.",
            "Young jackfruit has a neutral taste that can absorb spices, while ripe jackfruit has a sweet taste similar to other tropical fruits. Young jackfruit is often used as a meat substitute in vegetarian dishes such as curries and BBQ, while ripe jackfruit is eaten as fresh fruit or in desserts."
    };
    int[] images = {R.drawable.garlic, R.drawable.shallot, R.drawable.broccoli, R.drawable.tomato, R.drawable.cucumber, R.drawable.carrot, R.drawable.pumpkin, R.drawable.spinach, R.drawable.eggplant, R.drawable.jackfruit};

    ImageView imageView;
    TextView textView;
    TextView textViewPrice;
    TextView textViewCategory;
    TextView textViewInformation;
    TextView textViewExplanation;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_detail);

        getSupportActionBar().hide();

        gridView = findViewById(R.id.gridView);
        GridViewDictionaryUtils.setupGridView(gridView, this, names, images, prices, categories, informations, explanations);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.tvName);
        textViewPrice = findViewById(R.id.tvPrice);
        textViewCategory = findViewById(R.id.tvCategory);
        textViewInformation = findViewById(R.id.tvInformation);
        textViewExplanation = findViewById(R.id.tvExplanation);

        backBtn = findViewById(R.id.backBtn);

        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String selectedName = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image", 0);
            String selectedPrice = intent.getStringExtra("price");
            String selectedCategory = intent.getStringExtra("category");
            String selectedInformation = intent.getStringExtra("information");
            String selectedExplanation = intent.getStringExtra("explanation");

            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);
            textViewPrice.setText(selectedPrice);
            textViewCategory.setText(selectedCategory);
            textViewInformation.setText(selectedInformation);
            textViewExplanation.setText(selectedExplanation);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ingredient_detailActivity.this, DictionaryActivity.class));
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = names[position];
                int selectedImage = images[position];
                String selectedPrice = prices[position];
                String selectedCategory = categories[position];
                String selectedInformation = informations[position];
                String selectedExplanation = explanations[position];

                startActivity(new Intent(ingredient_detailActivity.this, ingredient_detailActivity.class)
                        .putExtra("name", selectedName)
                        .putExtra("image", selectedImage)
                        .putExtra("price", selectedPrice)
                        .putExtra("category", selectedCategory)
                        .putExtra("information", selectedInformation)
                        .putExtra("explanation", selectedExplanation));
            }
        });
    }
}