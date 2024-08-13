package com.example.jancook;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jancook.Model.Ingredient;

import java.util.List;

public class IngredientAdapter extends ArrayAdapter<Ingredient> {
    private Context context;
    private int resource;
    private List<Ingredient> ingredients;

    public IngredientAdapter(Context context, int resource, List<Ingredient> ingredients) {
        super(context, resource, ingredients);
        this.context = context;
        this.resource = resource;
        this.ingredients = ingredients;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        Ingredient ingredient = ingredients.get(position);

        TextView ingredientNameTextView = convertView.findViewById(R.id.ingredientName);
        ingredientNameTextView.setText(ingredient.getName());

        return convertView;
    }
}
