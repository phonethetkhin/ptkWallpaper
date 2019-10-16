package com.example.ptkwallpaper;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ptkwallpaper.Adapter.MainAdapter;
import com.example.ptkwallpaper.Models.CategoryModel;
import com.example.ptkwallpaper.Retrofit.Apis;
import com.example.ptkwallpaper.Retrofit.RetroObj;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rvMain;
Apis api;
SwipeRefreshLayout srflMain;
List<CategoryModel> categoryModelList=new ArrayList<>();
ImageView noInternetConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api= RetroObj.getRetrofitObj().create(Apis.class);
        rvMain=findViewById(R.id.rvMain);
        srflMain=findViewById(R.id.srflMain);
        noInternetConnection=findViewById(R.id.imgNoInternetConnection);

MainFunction();
srflMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
        srflMain.setRefreshing(true);
        MainFunction();
        srflMain.setRefreshing(false);
    }
});


    }
    public void MainFunction()
    {
        if(Network()) {
            noInternetConnection.setVisibility(View.GONE);
            rvMain.setVisibility(View.VISIBLE);

            CategoryModel cmodel = new CategoryModel("Latest", "https://images.pexels.com/photos/1122416/pexels-photo-1122416.jpeg");
            categoryModelList.add(cmodel);

             cmodel = new CategoryModel("Flower", "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg");
            categoryModelList.add(cmodel);

            cmodel = new CategoryModel("Nature", "https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg");
            categoryModelList.add(cmodel);

            cmodel = new CategoryModel("Animal", "https://images.pexels.com/photos/145939/pexels-photo-145939.jpeg");
            categoryModelList.add(cmodel);

            cmodel = new CategoryModel("Beauty", "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg");
            categoryModelList.add(cmodel);

            cmodel = new CategoryModel("Sport", "https://images.pexels.com/photos/46798/the-ball-stadion-football-the-pitch-46798.jpeg");
            categoryModelList.add(cmodel);

            cmodel = new CategoryModel("Cartoon", "https://images.pexels.com/photos/42415/pexels-photo-42415.jpeg");
            categoryModelList.add(cmodel);

            cmodel = new CategoryModel("Babies", "https://images.pexels.com/photos/36039/baby-twins-brother-and-sister-one-hundred-days.jpg");
            categoryModelList.add(cmodel);


            cmodel = new CategoryModel("Food", "https://images.pexels.com/photos/277253/pexels-photo-277253.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("Lights", "https://images.pexels.com/photos/220118/pexels-photo-220118.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("Fire", "https://images.pexels.com/photos/672636/pexels-photo-672636.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("Love", "https://images.pexels.com/photos/949586/pexels-photo-949586.jpeg");
            categoryModelList.add(cmodel);

            cmodel = new CategoryModel("Ocean", "https://images.pexels.com/photos/189349/pexels-photo-189349.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("Architecture", "https://images.pexels.com/photos/262367/pexels-photo-262367.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("Vehicle", "https://images.pexels.com/photos/248747/pexels-photo-248747.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("UnderWater", "https://images.pexels.com/photos/932638/pexels-photo-932638.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("Space", "https://images.pexels.com/photos/110854/pexels-photo-110854.jpeg");
            categoryModelList.add(cmodel);
            cmodel = new CategoryModel("Fantasy", "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg");
            categoryModelList.add(cmodel);

            rvMain.setLayoutManager(new GridLayoutManager(MainActivity.this, 2, LinearLayoutManager.VERTICAL, false));
            rvMain.setHasFixedSize(true);
            rvMain.setAdapter(new MainAdapter(categoryModelList));


        }
        else
        {
            Toast.makeText(this, "No Network !!!!", Toast.LENGTH_SHORT).show();
            noInternetConnection.setVisibility(View.VISIBLE);
            rvMain.setVisibility(View.GONE);
        }
    }
    public boolean Network()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) MainActivity.this.getSystemService(MainActivity.this.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }



}
