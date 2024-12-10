package com.example.movierecommendationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class recommendedmovies extends AppCompatActivity {
    private TextView[] movieTexts = new TextView[6];
    private ImageView[] movieImages = new ImageView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendedmovies);

        for (int i = 0; i < 6; i++) {
            int textId = getResources().getIdentifier("textview" + (i + 1), "id", getPackageName());
            int imageId = getResources().getIdentifier("image" + (i + 1), "id", getPackageName());
            movieTexts[i] = findViewById(textId);
            movieImages[i] = findViewById(imageId);
        }

        ArrayList<String> mylist = (ArrayList<String>) getIntent().getSerializableExtra("mylist");

        for (int i = 0; i < mylist.size() && i < 6; i++) {
            switch (mylist.get(i)) {
                case "comedy":
                    movieTexts[i].setText("Hang Over\nComedy\nIMDB:9.1/10");
                    movieImages[i].setImageResource(R.drawable.hangover);
                    break;
                case "action":
                    movieTexts[i].setText("Skylines\nAction\nIMDB:7.9/10");
                    movieImages[i].setImageResource(R.drawable.skylines);
                    break;
                case "horror":
                    movieTexts[i].setText("Conjuring 3\nHorror\nIMDB:8.1/10");
                    movieImages[i].setImageResource(R.drawable.conjuring3);
                    break;
                default:
                    movieTexts[i].setText("Unknown Genre");
                    movieImages[i].setImageResource(R.drawable.default_image);
                    break;
            }
        }
    }
}
