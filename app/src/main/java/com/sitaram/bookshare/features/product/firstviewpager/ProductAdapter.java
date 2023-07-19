package com.sitaram.bookshare.features.product.firstviewpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookshare.R;
import com.sitaram.bookshare.features.product.helper.BooksItem;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context context;
    List<BooksItem> bookPojoList;
    public ProductAdapter(Context context, List<BooksItem> bookPojoList) {
        this.context = context;
        this.bookPojoList = bookPojoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_book_items, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BooksItem book = bookPojoList.get(position);
        holder.tvAuther.setText("Author: " + book.getAuthor());
        holder.tvId.setText("Book Id: " + book.getId());
        holder.tvPrices.setText("Price: " + book.getPrice() + "");
        holder.tvRating.setText("Rating: " + book.getRating() + "");
        holder.tvDate.setText("Date: " + book.getDate());
        holder.tvTitle.setText("Title: " + book.getTitle());
        holder.tvDetail.setText("Details: " + book.getDetail());
        // or whatever you want
        Glide.with(holder.itemView.getContext()).load(book.getUrl()).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return bookPojoList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAuther, tvId, tvPrices, tvTitle, tvDetail, tvDate, tvRating;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAuther = itemView.findViewById(R.id.tvAuthor);
            tvId = itemView.findViewById(R.id.tvId);
            tvPrices = itemView.findViewById(R.id.tvPrices);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDetail = itemView.findViewById(R.id.tvDetail);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}
