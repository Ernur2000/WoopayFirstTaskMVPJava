package com.bolatovyernur.woopayfirsttaskmvpjava.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bolatovyernur.woopayfirsttaskmvpjava.databinding.FragmentRecentsBinding;
import com.squareup.picasso.Picasso;


public class RecentsFragment extends Fragment {
    FragmentRecentsBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecentsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Editable input = binding.etEnter.getText();

        binding.btnSubmit.setOnClickListener(view1 -> {
            if(TextUtils.isEmpty(input)){
                Toast.makeText(requireContext(), "Недостаточно символов", Toast.LENGTH_SHORT).show();
            }else{
                Picasso.get().load("https://cataas.com/cat/says/" + input).into(binding.ivImage);
            }
        });
    }
}