package com.example.school_project.examActivities;

import com.example.school_project.examModel.ExamModel1;
import com.example.school_project.examModel.T1;
import com.example.school_project.homeMainModel.HomeMainModel;
import com.example.school_project.homeModel.HomeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("api/v1/exams")
    Call<ExamModel1> call();

    @GET("api/v1/circulars")
    Call<HomeModel> getHomeModel();

    @GET("api/v1/home_page")
    Call<List<HomeMainModel>> getHomeMainModel();
}
