package com.sitaram.bookshare.features.product.secondviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookshare.R;
import com.sitaram.bookshare.features.product.helper.BooksItem;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    Context context;
    List<BooksItem> bookPojoList;
    public BookAdapter(Context context, List<BooksItem> bookPojoList) {
        this.context = context;
        this.bookPojoList = bookPojoList;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_item_list, parent, false);
        return new BookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BooksItem book = bookPojoList.get(position);
        // or whatever you want
        Glide.with(holder.itemView.getContext()).load(book.getUrl()).into(holder.ivImage);
    }

//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
//        BooksItem book = bookPojoList.get(position);
//        holder.tvAuther.setText("Author: " + book.getAuthor());
//        holder.tvId.setText("Book Id: " + book.getId());
//        holder.tvPrices.setText("Price: " + book.getPrice() + "");
//        holder.tvRating.setText("Rating: " + book.getRating() + "");
//        holder.tvDate.setText("Date: " + book.getDate());
//        holder.tvTitle.setText("Title: " + book.getTitle());
//        holder.tvDetail.setText("Details: " + book.getDetail());
//        // or whatever you want
//        Glide.with(holder.itemView.getContext()).load(book.getUrl()).into(holder.ivImage);
//    }

    @Override
    public int getItemCount() {
        return bookPojoList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivBookImageList);
        }
    }
}
