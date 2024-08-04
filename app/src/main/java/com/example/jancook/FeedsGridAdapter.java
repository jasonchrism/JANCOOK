package com.example.jancook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FeedsGridAdapter extends RecyclerView.Adapter<FeedsGridAdapter.ViewHolder> {

    private Context context;
    private List<Integer> imageList;
    private int columnWidth;

    public FeedsGridAdapter(Context context, List<Integer> imageList, int columnWidth) {
        this.context = context;
        this.imageList = imageList;
        this.columnWidth = columnWidth;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(imageList.get(position));
        ViewGroup.LayoutParams params = holder.imageView.getLayoutParams();
        params.width = columnWidth;
        params.height = columnWidth;
        holder.imageView.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }
}
