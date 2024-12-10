package com.example.movierecommendationapp.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movierecommendationapp.R;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MovieViewHolder> {

    private final Context context;
    private final ArrayList<CardMovieDetails> movies;

    public CardViewAdapter(Context context, ArrayList<CardMovieDetails> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        CardMovieDetails movie = movies.get(position);
        holder.movieName.setText(movie.getMovieName());
        holder.movieRatings.setText(movie.getRatings());
        holder.movieDescription.setText(movie.getMovieDescription());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieName, movieRatings, movieDescription;

        MovieViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieName);
            movieRatings = itemView.findViewById(R.id.movieRatings);
            movieDescription = itemView.findViewById(R.id.movieDescription);
        }
    }
}
