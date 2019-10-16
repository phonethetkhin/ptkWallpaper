package com.example.ptkwallpaper.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptkwallpaper.Models.CategoryModel;
import com.example.ptkwallpaper.ProductView;
import com.example.ptkwallpaper.Updated;
import com.example.ptkwallpaper.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
List<CategoryModel> Categorylist;

    public MainAdapter(List<CategoryModel> categorylist) {
        Categorylist = categorylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.mainlistitem,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvCategoryName.setText(Categorylist.get(position).getCategoryName());
        Picasso.get().load(Categorylist.get(position).getPhotoURL()).into(holder.imgPhotoCategory);
        holder.imgPhotoCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(), ProductView.class);
                Bundle b=new Bundle();
                b.putParcelable("Data",Categorylist.get(position));
                i.putExtras(b);

                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Categorylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgPhotoCategory;
        TextView tvCategoryName;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgPhotoCategory=v.findViewById(R.id.imgPhotoCategory);
            tvCategoryName=v.findViewById(R.id.tvCategoryName);
        }
    }
}
