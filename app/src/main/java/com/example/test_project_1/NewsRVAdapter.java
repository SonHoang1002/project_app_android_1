package com.example.test_project_1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRVAdapter extends  RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public NewsRVAdapter(ArrayList<Articles> articles, Context context) {
        this.articlesArrayList = articles;
        this.context = context;
    }


    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_items,parent,false);
       return new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Articles articles = articlesArrayList.get(position);
       holder.subTitleTV.setText(articles.getDescription());
       holder.titleTV.setText(articles.getTitle());
       Picasso.get().load(articles.getUrlToImage()).into(holder.imageView);
       holder.itemView.setOnClickListener(view -> {
           Intent intent = new Intent(context,NewDetailActivity.class);
           intent.putExtra("title",articles.getTitle());
           intent.putExtra("content",articles.getContent());
           intent.putExtra("desc",articles.getDescription());
           intent.putExtra("image",articles.getUrlToImage());
           intent.putExtra("url",articles.getUrl());
           context.startActivity(intent);
           Log.d("abc","50 new Adapter");
       });
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV,subTitleTV;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.textViewNews);
            subTitleTV = itemView.findViewById(R.id.textViewSubTitle);
            imageView =itemView.findViewById(R.id.imageViewNews);
        }
    }
}
