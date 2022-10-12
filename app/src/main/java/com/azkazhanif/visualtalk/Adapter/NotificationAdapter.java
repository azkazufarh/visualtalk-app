package com.azkazhanif.visualtalk.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.azkazhanif.visualtalk.Domain.NotificationDomain;
import com.azkazhanif.visualtalk.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>{

    Context context;
    ArrayList<NotificationDomain>notificationDomains;

    public NotificationAdapter(Context context, ArrayList<NotificationDomain>notificationDomains) {
        this.context = context;
        this.notificationDomains = notificationDomains;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_notification,
                parent,false);
        return new NotificationViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationDomain notificationDomain = notificationDomains.get(position);
        holder.notifTitle.setText(notificationDomain.getTitleNotif());
        holder.notifDesc.setText(notificationDomain.getSubtitleNotif());
    }

    @Override
    public int getItemCount() {
        return notificationDomains.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView notifTitle, notifDesc;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            notifTitle = itemView.findViewById(R.id.titleNotif);
            notifDesc  = itemView.findViewById(R.id.subtitleNotif);
        }
    }
}
