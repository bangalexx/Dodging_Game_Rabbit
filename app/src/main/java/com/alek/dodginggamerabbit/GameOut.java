package com.alek.dodginggamerabbit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOut extends AppCompatActivity {

    TextView tvPoints;
    TextView Highest;
    ImageView ivNewHighest;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_out);
        tvPoints = findViewById(R.id.tvPoints);
        Highest = findViewById(R.id.Highest);
        ivNewHighest = findViewById(R.id.ivNewHighest);
        int points = getIntent().getExtras().getInt("points");
        tvPoints.setText("" + points);
        sharedPreferences = getSharedPreferences("my_pref", 0);
        int highest = sharedPreferences.getInt("highest", 0);
        if (points > highest){
            ivNewHighest.setVisibility(View.VISIBLE);
            highest = points;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highest", highest);
            editor.commit();

        }
        Highest.setText("" + highest);

    }
    public void  restart(View view){
        Intent intent = new Intent(GameOut.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void exit(View view){
        finish();
    }
}
