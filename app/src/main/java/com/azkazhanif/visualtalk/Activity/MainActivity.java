package com.azkazhanif.visualtalk.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.azkazhanif.visualtalk.Fragment.HomeFragment;
import com.azkazhanif.visualtalk.Fragment.NotificationFragment;
import com.azkazhanif.visualtalk.Fragment.ProfilFragment;
import com.azkazhanif.visualtalk.R;
import com.azkazhanif.visualtalk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragement(new HomeFragment());

        binding.bottomNavigationMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragement(new HomeFragment());
                    break;
                case R.id.notification:
                    replaceFragement(new NotificationFragment());
                    break;
                case R.id.profile:
                    replaceFragement(new ProfilFragment());
                    break;
            }

            return true;
        });

    }

    private void replaceFragement(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}