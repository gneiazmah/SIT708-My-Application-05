package com.example.sit708_my_application_01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    TextView title, description;
    ImageView image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        title = findViewById(R.id.tvTitle);
        description = findViewById(R.id.tvDescription);
        image = findViewById(R.id.imageViewData);

        title.setText(getIntent().getExtras().getString("Title"));
        description.setText(getIntent().getExtras().getString("Des"));

        int myImage = getIntent().getIntExtra("Image", 0);
        image.setImageResource(myImage);

    }
}