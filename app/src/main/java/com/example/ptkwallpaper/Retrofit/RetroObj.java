package com.example.ptkwallpaper.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroObj {
    public static Retrofit retrofit=null;
public static final String BASEURL="https://api.pexels.com/v1/";
    public static Retrofit getRetrofitObj()
    {
if(retrofit==null) {
    retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
}
        return retrofit;
    }

}
