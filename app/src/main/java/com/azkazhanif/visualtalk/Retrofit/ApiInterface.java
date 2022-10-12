package com.azkazhanif.visualtalk.Retrofit;

import com.azkazhanif.visualtalk.Model.Category;
import com.azkazhanif.visualtalk.Model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("category.json")
    Call<List<Category>> getAllCategory();

    @GET("course.json")
    Call<List<Course>> getCourseContent();
}
