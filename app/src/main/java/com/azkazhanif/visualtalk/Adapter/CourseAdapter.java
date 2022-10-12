package com.azkazhanif.visualtalk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azkazhanif.visualtalk.Model.PlayList;
import com.azkazhanif.visualtalk.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<PlayList> playLists;

    public CourseAdapter(Context context, List<PlayList> playLists) {
        this.context = context;
        this.playLists = playLists;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.course_list_row_item,
                parent,false);
        return new CourseViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.contentName.setText(playLists.get(position).getName());
        holder.contentNumber.setText(position+1);
        holder.contentTime.setText(playLists.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView contentNumber, contentTime, contentName;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            contentNumber = itemView.findViewById(R.id.content_number);
            contentTime = itemView.findViewById(R.id.content_time);
            contentName = itemView.findViewById(R.id.content_title);
        }
    }
}
