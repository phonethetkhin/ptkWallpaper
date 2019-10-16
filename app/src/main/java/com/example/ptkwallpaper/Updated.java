package com.example.ptkwallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ptkwallpaper.Adapter.PhotoAdapter;
import com.example.ptkwallpaper.Models.PhotoModel;
import com.example.ptkwallpaper.Retrofit.Apis;
import com.example.ptkwallpaper.Retrofit.RetroObj;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Updated extends AppCompatActivity {
    RecyclerView rvMain;


    Apis api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated);



            rvMain=findViewById(R.id.rvMain);
            api= RetroObj.getRetrofitObj().create(Apis.class);
            Call<PhotoModel> photoModelCalllist=api.GetUpdatedsPhotos("563492ad6f917000010000014dc507ab46d144d489ce492465ecee75",15,1);
            photoModelCalllist.enqueue(new Callback<PhotoModel>() {
                @Override
                public void onResponse(Call<PhotoModel> call, Response<PhotoModel> response) {
                    if(response.isSuccessful())
                    {
                        PhotoModel MainRespondModel=response.body();
                        List<PhotoModel.Photo> photolist=MainRespondModel.getPhotos();
                        rvMain.setLayoutManager(new GridLayoutManager(Updated.this,3,RecyclerView.VERTICAL,false));
                        rvMain.setHasFixedSize(true);
                        rvMain.setAdapter(new PhotoAdapter(Updated.this,photolist));
                    }
                    else {
                        Toast.makeText(Updated.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<PhotoModel> call, Throwable t) {

                }
            });
    }
}
