package com.example.movierecommendationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class movieslist extends Activity {
    private ListView listView;
    private Button recommendBtn;

    private final String[] moviename = {
            "Johnny English Strikes Again",
            "The Tomorrow War",
            "The Dead Don't Die",
            "Forensic",
            "Tamasha",
            "Zodiac"
    };

    private final String[] movietype = {
            "comedy",
            "action",
            "horror",
            "thriller",
            "romance",
            "mystery"
    };

    private final String[] imdb = {
            "IMDB:7.4",
            "IMDB:9.1",
            "IMDB:6.8",
            "IMDB:8.2",
            "IMDB:8.4",
            "IMDB:7.9"
    };

    private final Integer[] imageid = {
            R.drawable.comedy,
            R.drawable.action,
            R.drawable.horror,
            R.drawable.thriller,
            R.drawable.romance,
            R.drawable.mystery
    };

    private final ArrayList<String> mylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movieslist);

        listView = findViewById(android.R.id.list);
        recommendBtn = findViewById(R.id.button);

        custommovielist custommovielist = new custommovielist(this, moviename, movietype, imdb, imageid);
        listView.setAdapter(custommovielist);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Toast.makeText(getApplicationContext(), "You Selected: " + moviename[position], Toast.LENGTH_SHORT).show();
            mylist.add(movietype[position]);
        });

        recommendBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), recommendedmovies.class);
            intent.putExtra("mylist", mylist);
            startActivity(intent);
        });
    }
}
