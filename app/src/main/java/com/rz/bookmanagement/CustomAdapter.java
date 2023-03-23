package com.rz.bookmanagement;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private Context context;
    Activity activity;
    private ArrayList book_id, book_title, book_author, book_pages;

    int position;

    CustomAdapter(Activity activity, Context context,
                  ArrayList book_id,
                  ArrayList book_title,
                  ArrayList book_author,
                  ArrayList book_pages
    ){
    this.activity= activity;
    this.context = context;
    this.book_id = book_id;
    this.book_title = book_title;
    this.book_author = book_author;
    this.book_pages = book_pages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.book_idText.setText(String.valueOf(book_id.get(position)));
        holder.book_titleTxt.setText(String.valueOf(book_title.get(position)));
        holder.book_authorTxt.setText(String.valueOf(book_author.get(position)));
        holder.book_pageTxt.setText(String.valueOf(book_pages.get(position)));
        holder.mainLayout.setOnClickListener((view -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(book_id.get(position)));
            intent.putExtra("title", String.valueOf(book_title.get(position)));
            intent.putExtra("author", String.valueOf(book_author.get(position)));
            intent.putExtra("pages", String.valueOf(book_pages.get(position)));
            activity.startActivityForResult(intent, 1);
        }));
    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView book_idText, book_titleTxt,book_authorTxt, book_pageTxt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_idText = itemView.findViewById(R.id.book_idText);
            book_titleTxt = itemView.findViewById(R.id.book_titleTxt);
            book_pageTxt = itemView.findViewById(R.id.book_pageTxt);
            book_authorTxt = itemView.findViewById(R.id.book_authorTxt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
