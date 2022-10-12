package com.azkazhanif.visualtalk.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.azkazhanif.visualtalk.Domain.InfoDomain;
import com.azkazhanif.visualtalk.R;

import java.util.ArrayList;

public class InfoAdaptor extends RecyclerView.Adapter<InfoAdaptor.ViewHolder> {
    ArrayList<InfoDomain>infoDomains;

    public InfoAdaptor(ArrayList<InfoDomain> infoDomains) {
        this.infoDomains = infoDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_infokreatif,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.infoTitle.setText(infoDomains.get(position).getTitle());
        holder.infoCategory.setText(infoDomains.get(position).getCategory());
        holder.infoDate.setText(infoDomains.get(position).getDate());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(infoDomains.get(position).getImg(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.infoImg);

    }

    @Override
    public int getItemCount() {
        return infoDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView infoTitle, infoCategory, infoDate;
        ImageView infoImg;
        ConstraintLayout infoLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            infoTitle = itemView.findViewById(R.id.titleInfo);
            infoImg = itemView.findViewById(R.id.imgInfo);
            infoDate = itemView.findViewById(R.id.dateInfo);
            infoCategory = itemView.findViewById(R.id.categoryInfo);
            infoLayout =  itemView.findViewById(R.id.mainLayout2);
        }
    }
}
