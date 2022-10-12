package com.azkazhanif.visualtalk.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azkazhanif.visualtalk.Activity.CoursePageActivity;
import com.azkazhanif.visualtalk.Model.Category;
import com.azkazhanif.visualtalk.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_category,
                parent,false);
        return new CategoryViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.courseName.setText(categoryList.get(position).getCategoryName());
        holder.totalCourse.setText(categoryList.get(position).getTotalCourses());

        Glide.with(context).load(categoryList.get(position).getImage()).into(holder.courseImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, CoursePageActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView courseImage;
        TextView courseName, totalCourse;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            courseImage = itemView.findViewById(R.id.course);
            courseName = itemView.findViewById(R.id.course_name);
            totalCourse = itemView.findViewById(R.id.total_course);
        }
    }
}
