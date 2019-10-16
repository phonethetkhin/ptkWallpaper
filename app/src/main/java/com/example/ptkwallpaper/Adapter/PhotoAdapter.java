package com.example.ptkwallpaper.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptkwallpaper.Models.PhotoModel;
import com.example.ptkwallpaper.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    Context context;
    List<PhotoModel.Photo> Photolist;

    public PhotoAdapter(Context context, List<PhotoModel.Photo> photolist) {
        this.context = context;
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
    public void onBindViewHolder(@NonNull ViewHolder h, int position) {
        Picasso.get().load(Photolist.get(position).getSrc().getOriginal()).into(h.imgPhoto);
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
