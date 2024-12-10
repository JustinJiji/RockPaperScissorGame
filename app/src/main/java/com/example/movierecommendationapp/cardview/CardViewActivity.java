package com.example.movierecommendationapp.cardview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.movierecommendationapp.R;

import java.util.ArrayList;

public class CardViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardViewAdapter adapter;
    private ArrayList<CardMovieDetails> moviesArrayList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_views);

        InitializeCardView();
    }

    private void InitializeCardView() {
        recyclerView = findViewById(R.id.recyclerViewCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        moviesArrayList = new ArrayList<>();
        progressBar = findViewById(R.id.progress_bar);

        progressBarVisible();
        loadFakeData();

        adapter = new CardViewAdapter(this, moviesArrayList);
        recyclerView.setAdapter(adapter);
        progressBarInVisible();
    }

    private void progressBarVisible() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    private void progressBarInVisible() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void loadFakeData() {
        moviesArrayList.add(new CardMovieDetails("1", "Inception", "Ratings: 8.8/10", "A mind-bending thriller.", "/path_inception_backdrop", "/path_inception_poster"));
        moviesArrayList.add(new CardMovieDetails("2", "The Dark Knight", "Ratings: 9.0/10", "A crime drama with Batman.", "/path_dark_knight_backdrop", "/path_dark_knight_poster"));
    }
}
