package com.anshul.buzzme;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anshul.buzzme.databinding.ActivityImageViewBinding;
import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    ActivityImageViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityImageViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        String image=getIntent().getStringExtra("image");

        Glide.with(this).load(image).into(binding.imageView);
    }
}