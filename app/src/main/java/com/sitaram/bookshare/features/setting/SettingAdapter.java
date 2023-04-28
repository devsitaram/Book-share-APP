package com.sitaram.bookshare.features.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookshare.R;

import java.util.List;


public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder>{

    Context context;
    List<SettingPojo> settingPojoList;
    // constructor
    public SettingAdapter(Context context, List<SettingPojo> settingPojoList) {
        this.context = context;
        this.settingPojoList = settingPojoList;
    }

    @NonNull
    @Override
    public SettingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_setting_items_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.ViewHolder holder, int position) {
        holder.tvUserSetting.setText(settingPojoList.get(position).tvSettingTitle);
    }

    @Override
    public int getItemCount() {
        return settingPojoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvUserSetting;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserSetting = itemView.findViewById(R.id.tvUserSetting);
        }
    }
}
