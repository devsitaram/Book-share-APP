package com.sitaram.bookshare.features.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshare.R;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.pViewHolder> {

    Context context;
    List<CollectionPojo> collectionPojoList;
    // constructor
    public ProfileAdapter(Context context, List<CollectionPojo> collectionPojoList) {
        this.context = context;
        this.collectionPojoList = collectionPojoList;
    }

    @NonNull
    @Override
    public ProfileAdapter.pViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.profile_collection_items, parent, false);
        return new pViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.pViewHolder holder, int position) {
        CollectionPojo pojo = collectionPojoList.get(position);
        holder.ivTypesOfImage.setImageResource(pojo.images);
        holder.tvImageName.setText(pojo.imageName);
        holder.tvNumOfImage.setText(pojo.numberOfImages);
    }

    @Override
    public int getItemCount() {
        return collectionPojoList.size();
    }

    public static class pViewHolder extends RecyclerView.ViewHolder {
        ImageView ivTypesOfImage;
        TextView tvImageName, tvNumOfImage;
        public pViewHolder(@NonNull View itemView) {
            super(itemView);
            ivTypesOfImage =itemView.findViewById(R.id.ivTypesOfImage);
            tvImageName =itemView.findViewById(R.id.tvNameOfImage);
            tvNumOfImage =itemView.findViewById(R.id.tvNoOfImage);
        }
    }
}
