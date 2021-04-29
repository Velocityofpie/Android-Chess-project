package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chess extends AppCompatActivity {

    Button playerVplayer, gamesPlayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_interface);

        playerVplayer = findViewById(R.id.playerVplayer);
        gamesPlayed = findViewById(R.id.gamesPlayed);

        playerVplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.play_chess);
            }
        });

        gamesPlayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.saved_games);
            }
        });
    }
}