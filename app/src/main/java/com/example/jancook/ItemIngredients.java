package com.example.jancook;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.jancook.Model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class ItemIngredients extends AppCompatActivity {

    private LinearLayout ingredientsContainer;
    private LayoutInflater inflater;
    private List<Ingredient> ingredientList;
    private List<Ingredient> filteredIngredientList;
    private IngredientAdapter searchResultsAdapter;
    private ListView searchResultsListView;
    private EditText searchView;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        submitButton = findViewById(R.id.submitButton);

        // Set click listener for the start button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FilledWeeklyPlannerFragment fragment = FilledWeeklyPlannerFragment.newInstance(1);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

//                Intent intent = new Intent(ItemIngredients.this, FilledWeeklyPlannerHost.class);
//                startActivity(intent);
//                finish();
            }
        });

        searchView = findViewById(R.id.searchView);
        searchResultsListView = findViewById(R.id.searchResultsListView);
        ingredientsContainer = findViewById(R.id.ingredientsContainer);
        inflater = LayoutInflater.from(this);

        ingredientList = new ArrayList<>();
        filteredIngredientList = new ArrayList<>();
        populateIngredientList();

        searchResultsAdapter = new IngredientAdapter(this, R.layout.list_item, filteredIngredientList);
        searchResultsListView.setAdapter(searchResultsAdapter);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterIngredients(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        searchResultsListView.setOnItemClickListener((parent, view, position, id) -> {
            Ingredient selectedIngredient = filteredIngredientList.get(position);
            addIngredient(selectedIngredient);
            searchView.setText("");
            searchResultsAdapter.clear();
            searchResultsListView.setVisibility(View.GONE);
        });
    }

    private void populateIngredientList() {
        ingredientList.add(new Ingredient("Sugar"));
        ingredientList.add(new Ingredient("Salt"));
        ingredientList.add(new Ingredient("Flour"));
        ingredientList.add(new Ingredient("Butter"));
        ingredientList.add(new Ingredient("Milk"));
        ingredientList.add(new Ingredient("Onion"));
        ingredientList.add(new Ingredient("Bhok Coy"));
        ingredientList.add(new Ingredient("Meat"));
        ingredientList.add(new Ingredient("Tomato"));
        ingredientList.add(new Ingredient("Cabbage"));
        ingredientList.add(new Ingredient("Noodle"));
        ingredientList.add(new Ingredient("Tofu"));
        ingredientList.add(new Ingredient("Egg"));
        ingredientList.add(new Ingredient("Chili"));
        ingredientList.add(new Ingredient("Orange"));
        // Add more mock ingredients as needed
    }

    private void filterIngredients(String searchText) {
        filteredIngredientList.clear();
        if (!searchText.isEmpty()) {
            for (Ingredient ingredient : ingredientList) {
                if (ingredient.getName().toLowerCase().contains(searchText.toLowerCase())) {
                    filteredIngredientList.add(ingredient);
                }
            }
            searchResultsAdapter.notifyDataSetChanged();
            searchResultsListView.setVisibility(View.VISIBLE);
        } else {
            searchResultsListView.setVisibility(View.GONE);
        }
    }

    private void addIngredient(Ingredient ingredient) {
        View ingredientView = inflater.inflate(R.layout.item_ingredient, ingredientsContainer, false);

        TextView ingredientNameTextView = ingredientView.findViewById(R.id.ingredientName);
        EditText ingredientAmountEditText = ingredientView.findViewById(R.id.ingredientAmount);
        ImageView deleteButton = ingredientView.findViewById(R.id.deleteButton);

        ingredientNameTextView.setText(ingredient.getName());

        ingredientAmountEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAmountDialog(ingredient, ingredientAmountEditText);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredientsContainer.removeView(ingredientView);
            }
        });

        ingredientsContainer.addView(ingredientView);
    }

    private void showAmountDialog(Ingredient ingredient, EditText ingredientAmountEditText) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_amount);

        EditText amountInput = dialog.findViewById(R.id.amountInput);
        Spinner unitSpinner = dialog.findViewById(R.id.unitSpinner);
        Button confirmButton = dialog.findViewById(R.id.confirmButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString();
                String unit = unitSpinner.getSelectedItem().toString();
                ingredient.setAmount(amount);
                ingredient.setUnit(unit);
                ingredientAmountEditText.setText(amount + " " + unit);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}


