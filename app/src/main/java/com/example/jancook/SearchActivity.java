package com.example.jancook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataSearchClass> dataSearchClassList;
    SearchAdapter searchAdapter;
    DataSearchClass androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        ImageView searchButton = findViewById(R.id.backBtn);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(SearchActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataSearchClassList = new ArrayList<>();

        androidData = new DataSearchClass("Trending in Indonesia" , "#GurameBakar" , "1290 post");
        dataSearchClassList.add(androidData);
        androidData = new DataSearchClass("Trending in Japan" , "#EsCendol" , "6543 post");
        dataSearchClassList.add(androidData);
        androidData = new DataSearchClass("Trending in English" , "#EsDawet" , "1760 post");
        dataSearchClassList.add(androidData);
        androidData = new DataSearchClass("Trending in Germany" , "#RujakCingur" , "3454 post");
        dataSearchClassList.add(androidData);
        androidData = new DataSearchClass("Trending in Malaysia" , "#Martabak" , "6545 post");
        dataSearchClassList.add(androidData);
        androidData = new DataSearchClass("Trending in Singapore" , "#SotoAyam" , "2214 post");
        dataSearchClassList.add(androidData);
        androidData = new DataSearchClass("Trending in Laos" , "#Rendang" , "9007 post");
        dataSearchClassList.add(androidData);
        androidData = new DataSearchClass("Trending in Honduras" , "#Tacos" , "6678 post");
        dataSearchClassList.add(androidData);

        searchAdapter = new SearchAdapter(SearchActivity.this, dataSearchClassList);
        recyclerView.setAdapter(searchAdapter);
    }
    private void searchList(String text){
        List<DataSearchClass> dataSearchClasses = new ArrayList<>();
        for (DataSearchClass data : dataSearchClassList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchClasses.add(data);
            }
        }
        if (dataSearchClasses.isEmpty()){
            Toast.makeText(this , "Not Found" ,Toast.LENGTH_SHORT).show();
        }else {
            searchAdapter.setSearchList(dataSearchClasses);
        }
    }
}