package com.example.ptkwallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.example.ptkwallpaper.Adapter.ProdcutViewAdapter;
import com.example.ptkwallpaper.Models.CategoryModel;
import com.example.ptkwallpaper.Models.PhotoModel;
import com.example.ptkwallpaper.Retrofit.Apis;
import com.example.ptkwallpaper.Retrofit.RetroObj;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductView extends AppCompatActivity {
    RecyclerView rvProductView;
CategoryModel categoryModel;
String keyword;
Apis api;
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_product_view);
    rvProductView = findViewById(R.id.rvProductView);

    categoryModel = getIntent().getParcelableExtra("Data");
    keyword = categoryModel.getCategoryName();
    if (keyword.equals("Latest")) {
        Intent i = new Intent(ProductView.this, Updated.class);
        startActivity(i);
    } else {


        api = RetroObj.getRetrofitObj().create(Apis.class);
        Call<PhotoModel> photoModelCall = api.GetSearchPhotos("563492ad6f917000010000014dc507ab46d144d489ce492465ecee75", keyword, 15, 1);
        photoModelCall.enqueue(new Callback<PhotoModel>() {
            @Override
            public void onResponse(Call<PhotoModel> call, Response<PhotoModel> response) {
                if (response.isSuccessful()) {
                    PhotoModel photoModel = response.body();
                    List<PhotoModel.Photo> photoList = photoModel.getPhotos();
                    rvProductView.setLayoutManager(new GridLayoutManager(ProductView.this, 3, LinearLayoutManager.VERTICAL, false));
                    rvProductView.setHasFixedSize(true);
                    rvProductView.setAdapter(new ProdcutViewAdapter(photoList));
                } else {
                    Toast.makeText(ProductView.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PhotoModel> call, Throwable t) {

            }
        });


    }
}
}
