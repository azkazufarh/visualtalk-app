package com.azkazhanif.visualtalk.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.azkazhanif.visualtalk.Adapter.OnBoardingAdapter;
import com.azkazhanif.visualtalk.Domain.OnBoardingDomain;
import com.azkazhanif.visualtalk.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    private OnBoardingAdapter onBoardingAdapter;
    private LinearLayout layoutOnBoardingIndicator;
    private MaterialButton buttonOnBoardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        layoutOnBoardingIndicator = findViewById(R.id.layoutOnBoarding);
        buttonOnBoardingAction = findViewById(R.id.buttonOnBoardingAction);

        setupOnBoardingDomains();

        ViewPager2 onBoardingViewPager = findViewById(R.id.onBoardingViewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setupOnBoardingIndicator();
        setCurrentOnBoardingIndicator(0);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });

        buttonOnBoardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()) {
                    onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupOnBoardingDomains() {
        List<OnBoardingDomain> onBoardingDomains = new ArrayList<>();

        OnBoardingDomain learnEverywhere = new OnBoardingDomain();
        learnEverywhere.setTitle("Learning Everywhere");
        learnEverywhere.setDescription("Sobat visual kini dapat dengan mudah menikmati pembelajaran dimana saja!");
        learnEverywhere.setImage(R.drawable.learning);

        OnBoardingDomain careerConsultation = new OnBoardingDomain();
        careerConsultation.setTitle("Carrer Consultaton");
        careerConsultation.setDescription("Sobat visual bisa dapat mengembangkan skillnya lebih terarah!");
        careerConsultation.setImage(R.drawable.career);

        OnBoardingDomain meetMentor = new OnBoardingDomain();
        meetMentor.setTitle("Meet A Mentor");
        meetMentor.setDescription("Sobat visual akan dilatih dengan mentor ternama");
        meetMentor.setImage(R.drawable.mentor);

        onBoardingDomains.add(learnEverywhere);
        onBoardingDomains.add(careerConsultation);
        onBoardingDomains.add(meetMentor);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingDomains);
    }

    private void setupOnBoardingIndicator() {
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnBoardingIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentOnBoardingIndicator(int index) {
        int childCount = layoutOnBoardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnBoardingIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),
                                R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),
                                R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if (index == onBoardingAdapter.getItemCount()-1) {
            buttonOnBoardingAction.setText("Get Started!");
        } else {
            buttonOnBoardingAction.setText("Next");
        }
    }
}