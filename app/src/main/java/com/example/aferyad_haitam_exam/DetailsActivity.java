package com.example.aferyad_haitam_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView=findViewById(R.id.image);

        String url=getIntent().getStringExtra("photo");

        Glide.with(this).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}