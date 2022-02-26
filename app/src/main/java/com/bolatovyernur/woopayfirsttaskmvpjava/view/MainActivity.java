package com.bolatovyernur.woopayfirsttaskmvpjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.bolatovyernur.woopayfirsttaskmvpjava.R;
import com.bolatovyernur.woopayfirsttaskmvpjava.databinding.ActivityMainBinding;
import com.bolatovyernur.woopayfirsttaskmvpjava.fragments.FavouritesFragment;
import com.bolatovyernur.woopayfirsttaskmvpjava.fragments.NearbyFragment;
import com.bolatovyernur.woopayfirsttaskmvpjava.fragments.RecentsFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final RecentsFragment recentsFragment = new RecentsFragment();
    private final FavouritesFragment favouritesFragment = new FavouritesFragment();
    private final NearbyFragment nearbyFragment = new NearbyFragment();
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        replaceFragment(recentsFragment);

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.ic_recent:
                    replaceFragment(recentsFragment);
                    return true;
                case R.id.ic_favourites:
                    replaceFragment(favouritesFragment);
                    return true;
                case R.id.ic_nearby:
                    replaceFragment(nearbyFragment);
                    return true;
            }
            return false;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }
}