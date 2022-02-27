package com.bolatovyernur.woopayfirsttaskmvpjava.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bolatovyernur.woopayfirsttaskmvpjava.databinding.FragmentFavouritesBinding;
import com.bolatovyernur.woopayfirsttaskmvpjava.interfaces.FactInterface;
import com.bolatovyernur.woopayfirsttaskmvpjava.presenter.FactPresenter;

public class FavouritesFragment extends Fragment implements FactInterface.FactView {
    FragmentFavouritesBinding binding;
    private FactPresenter factPresenter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFavouritesBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        factPresenter = new FactPresenter(this);
        binding.btnFact.setOnClickListener(view1 -> {
            factPresenter.networkCall();
        });
        binding.btnTranslatedText.setOnClickListener(view1 -> {
            factPresenter.translateCall();
        });
    }

    @Override
    public void updateViewData(String text) {
        binding.tvRecent.setText(text);
    }

    @Override
    public void updateViewTranslatedText(String text) {
        binding.tvTranslatedText.setText(text);
    }
}