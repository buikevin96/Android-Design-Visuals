package com.example.kevinbui.seekbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView)findViewById(R.id.resultID);
        seekBar = (SeekBar)findViewById(R.id.seekBarID);

        resultTextView.setText("Pain Level: " + seekBar.getProgress() + "/" + seekBar.getMax()); // Sets the result to 0
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                resultTextView.setTextColor(Color.GRAY); // Sets default color to gray
                resultTextView.setText("Pain Level: " + seekBar.getProgress() + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SB", "OnStartTrackingTouch");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // When SeekBar Value is 7 or greater
                if (seekBar.getProgress() >= 7) {
                    resultTextView.setTextColor(Color.RED); // Change Text color to Red
                }
                Log.d("SB", "OnStop");
            }
        });
    }
}
