package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chess extends AppCompatActivity {
    private  Button Bpvp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_interface);
        Bpvp= (Button) findViewById(R.id.Bpvp);
        Bpvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGame();

            }
        });

    }
    public void openGame(){


    }
}