package com.example.jancook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class RecipeStepAdapter extends RecyclerView.Adapter<RecipeStepAdapter.RecipeStepViewHolder> {

    private List<String> stepDescriptions;
    private LayoutInflater inflater;

    public RecipeStepAdapter(Context context, List<String> stepDescriptions) {
        this.stepDescriptions = stepDescriptions;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecipeStepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recipe_step, parent, false);
        return new RecipeStepViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeStepViewHolder holder, int position) {
        String stepDescription = stepDescriptions.get(position);
        holder.stepDescription.setText("");
        holder.stepNumber.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return stepDescriptions.size();
    }

    public void onItemMove(int fromPosition, int toPosition) {
        // Swap items in the list
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(stepDescriptions, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(stepDescriptions, i, i - 1);
            }
        }

        // Notify adapter of the move
        notifyItemMoved(fromPosition, toPosition);

        // Update the numbers to reflect the new order
        notifyDataSetChanged();
    }

    public class RecipeStepViewHolder extends RecyclerView.ViewHolder {
        TextView stepNumber;
        TextView stepDescription;
        ImageView deleteButton;

        public RecipeStepViewHolder(@NonNull View itemView) {
            super(itemView);
            stepNumber = itemView.findViewById(R.id.stepNumber);
            stepDescription = itemView.findViewById(R.id.stepDescription);
            deleteButton = itemView.findViewById(R.id.deleteButton);

            deleteButton.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    stepDescriptions.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, stepDescriptions.size());
                }
            });
        }
    }
}
