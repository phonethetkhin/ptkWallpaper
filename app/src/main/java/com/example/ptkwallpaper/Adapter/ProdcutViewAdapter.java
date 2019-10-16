package com.example.ptkwallpaper.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptkwallpaper.Models.PhotoModel;
import com.example.ptkwallpaper.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProdcutViewAdapter extends RecyclerView.Adapter<ProdcutViewAdapter.ViewHolder> {

     List<PhotoModel.Photo> Photolist;

    public ProdcutViewAdapter(List<PhotoModel.Photo> photolist) {
        Photolist = photolist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.photlistitem,parent,false);
        ViewHolder holder=new ViewHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(Photolist.get(position).getSrc().getOriginal()).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return Photolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
ImageView imgPhoto;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgPhoto=v.findViewById(R.id.imgPhoto);
        }
    }
}
