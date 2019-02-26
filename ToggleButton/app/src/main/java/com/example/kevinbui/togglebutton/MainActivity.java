package com.example.kevinbui.togglebutton;

import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView resultView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageViewID);
        resultView = (TextView)findViewById(R.id.peekABooTextView);

        toggleButton = (ToggleButton)findViewById(R.id.toggleButtonID);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    resultView.setVisibility(View.VISIBLE);// To make view visible
                    imageView.setVisibility(ImageView.VISIBLE); // To make image visible
                } else {
                    // The toggle is disabled
                    resultView.setVisibility(View.INVISIBLE);// To make view invisible
                    imageView.setVisibility(ImageView.INVISIBLE); // To make image invisible
                }
            }
        });
    }
}
