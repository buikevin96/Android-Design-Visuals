package com.example.kevinbui.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_field);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                int duration = mp.getDuration(); // Returns duration of mp3 being played
                String mDuration = String.valueOf(duration/1000); // In seconds

                Toast.makeText(getApplicationContext(),"duration " + mDuration, Toast.LENGTH_LONG).show();
            }
        });

        playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    // Stop and give option to start again
                    pauseMusic();
                } else {
                    startMusic();
                }
            }
        });
    }

    public void pauseMusic(){
        if (mediaPlayer != null){
            mediaPlayer.pause(); // When the media player is paused
            playButton.setText("Play"); // The button will change its text to Play
        }
    }

    public void startMusic(){
        if (mediaPlayer != null){
            mediaPlayer.start(); // when the media is playing
            playButton.setText("Pause"); // The button will change its text to pauise
        }

    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop(); // Stop the player
            mediaPlayer.release(); // Release resources back to android
            mediaPlayer=null; // Kills the media player object

        }
        super.onDestroy();
    }
}


