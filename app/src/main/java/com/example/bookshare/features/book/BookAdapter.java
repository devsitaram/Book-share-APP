package com.example.bookshare.features.book;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshare.R;
import com.example.bookshare.features.book.helper.BooksItem;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_items, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BooksItem book = bookPojoList.get(position);
        holder.tvAuther.setText("Author: "+book.getAuthor());
        holder.tvId.setText("Book Id: "+book.getId());
        holder.tvPrices.setText("Price: "+book.getPrice()+"");
        holder.tvRating.setText("Rating: "+book.getRating()+"");
        holder.tvDate.setText("Date: "+book.getDate());
        holder.tvTitle.setText("Title: "+book.getTitle());
        holder.tvDetail.setText("Details: "+book.getDetail());

//        URL url = null;
//        try {
//            url = new URL(book.getUrl());
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            holder.ivImage.setImageBitmap(bmp);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

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
