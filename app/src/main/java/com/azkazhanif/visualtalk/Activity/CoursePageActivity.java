package com.azkazhanif.visualtalk.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.azkazhanif.visualtalk.Adapter.CategoryAdapter;
import com.azkazhanif.visualtalk.Adapter.CourseAdapter;
import com.azkazhanif.visualtalk.Model.Category;
import com.azkazhanif.visualtalk.Model.Course;
import com.azkazhanif.visualtalk.Model.PlayList;
import com.azkazhanif.visualtalk.R;
import com.azkazhanif.visualtalk.Retrofit.ApiInterface;
import com.azkazhanif.visualtalk.Retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoursePageActivity extends AppCompatActivity {

    RecyclerView courseRecyclerView;
    ApiInterface apiInterface;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);
        Call<List<Course>> call = apiInterface.getCourseContent();

        courseRecyclerView = findViewById(R.id.course_recycler);


        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> courseList = response.body();
                getCourseContent(courseList.get(0).getPlayList());
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Toast.makeText(CoursePageActivity.this,
                        "No response from server",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCourseContent(List<PlayList> playLists) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        courseRecyclerView.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this, playLists);
        courseRecyclerView.setAdapter(courseAdapter);
        courseAdapter.notifyDataSetChanged();
    }
}