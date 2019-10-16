package com.example.ptkwallpaper.Retrofit;

import com.example.ptkwallpaper.Models.PhotoModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Apis {

    @GET("curated")
    Call<PhotoModel> GetUpdatedsPhotos(
            @Header("Authorization") String Apikey,

      @Query("per_page") int maxpage,
      @Query("page") int page

    );
    @GET("search")
    Call<PhotoModel> GetSearchPhotos(
      @Header("Authorization") String Apikey,
      @Query("query") String Query,
      @Query("per_page") int maxpage,
      @Query("page") int page


    );
}
