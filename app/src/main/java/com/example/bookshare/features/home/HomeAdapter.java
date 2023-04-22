package com.example.bookshare.features.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshare.R;
import com.example.bookshare.features.book.helper.BooksItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.hViewHolder> {
    Context context;

    List<BooksItem> bookPojoList;
    @NonNull
    @Override
    public HomeAdapter.hViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_book_items, parent, false);
        return new HomeAdapter.hViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.hViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bookPojoList.size();
    }

    public static class hViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBookImage;
        TextView tvBookTitle;
        public hViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBookImage = itemView.findViewById(R.id.ivBookItem);
            tvBookTitle = itemView.findViewById(R.id.tvBookTitle);
        }
    }
}
