package com.example.jancook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataSearchClass> dataList;

    public void setSearchList(List<DataSearchClass> dataSearchClassList){
        this.dataList = dataSearchClassList;
        notifyDataSetChanged();
    }
    public SearchAdapter(Context context , List<DataSearchClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_search_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recLocation.setText(dataList.get(position).getDataLocation());
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recPost.setText(dataList.get(position).getDataPost());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SearchResultActivity.class);
                intent.putExtra("Location" , dataList.get(holder.getAdapterPosition()).getDataLocation());
                intent.putExtra("Title" , dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Post" , dataList.get(holder.getAdapterPosition()).getDataPost());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView recLocation, recTitle, recPost;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recLocation = itemView.findViewById(R.id.recLocation);
        recTitle = itemView.findViewById(R.id.recTitle);
        recPost = itemView.findViewById(R.id.recPost);
        recCard = itemView.findViewById(R.id.recCard);
    }
}
