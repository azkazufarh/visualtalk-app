package com.azkazhanif.visualtalk.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azkazhanif.visualtalk.Domain.OnBoardingDomain;
import com.azkazhanif.visualtalk.R;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.onBoardingViewHolder> {

    private List<OnBoardingDomain> onBoardingDomains;

    public OnBoardingAdapter(List<OnBoardingDomain> onBoardingDomains) {
        this.onBoardingDomains = onBoardingDomains;
    }

    @NonNull
    @Override
    public onBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new onBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull onBoardingViewHolder holder, int position) {
        holder.setOnBoardingData(onBoardingDomains.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingDomains.size();
    }

    class onBoardingViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle, textDescription;
        private ImageView imageOnBoarding;

        onBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnBoarding = itemView.findViewById(R.id.imageOnBoarding);
        }

        void setOnBoardingData(OnBoardingDomain onBoardingDomain) {
            textTitle.setText(onBoardingDomain.getTitle());
            textDescription.setText(onBoardingDomain.getDescription());
            imageOnBoarding.setImageResource(onBoardingDomain.getImage());
        }
    }
}
