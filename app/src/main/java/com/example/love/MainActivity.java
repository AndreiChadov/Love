package com.example.love;

import android.media.MediaPlayer;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    boolean isMusicPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void heartClick(View view) {
        if (!isMusicPlaying) {
            isMusicPlaying = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    player = MediaPlayer.create(MainActivity.this, R.raw.stas_mixajlov_vse_dlya_tebya);
                    player.start();
                }
            }).start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.pause();
    }
}