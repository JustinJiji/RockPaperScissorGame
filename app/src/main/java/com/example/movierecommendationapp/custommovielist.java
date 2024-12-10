package com.example.movierecommendationapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custommovielist extends ArrayAdapter<String> {
    private final String[] moviename;
    private final String[] movietype;
    private final String[] imdb;
    private final Integer[] imageid;
    private final Activity context;

    public custommovielist(Activity context, String[] moviename, String[] movietype, String[] imdb, Integer[] imageid) {
        super(context, R.layout.row_item, moviename);
        this.context = context;
        this.moviename = moviename;
        this.movietype = movietype;
        this.imdb = imdb;
        this.imageid = imageid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            row = inflater.inflate(R.layout.row_item, parent, false);
        }

        TextView textViewmovie = row.findViewById(R.id.textViewmovie);
        TextView textViewtype = row.findViewById(R.id.textViewtype);
        TextView textViewimdb = row.findViewById(R.id.textViewimdb);
        ImageView imageFlag = row.findViewById(R.id.imageViewFlag);

        textViewmovie.setText(moviename[position]);
        textViewtype.setText(movietype[position]);
        textViewimdb.setText(imdb[position]);
        imageFlag.setImageResource(imageid[position]);

        return row;
    }
}
