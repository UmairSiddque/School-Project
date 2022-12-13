package com.example.school_project.examActivities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null;
    public  MyApi api(){
        if(retrofit==null){
            String BASE_URL = "https://6385edfdbeaa6458266d7254.mockapi.io/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MyApi.class);
    }


}
