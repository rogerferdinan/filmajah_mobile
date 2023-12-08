package com.rogerferdinan.filmajah.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //private final TextView tvNama;
       // private final ImageView ivMovie;
        public ViewHolder(View v) {
            super(v);
            // tvNama = (TextView) v.findViewById(R.id.tvNama);
            // ivMovie = (ImageView) v.findViewById(R.id.ivMovie);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_info, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String base_url = "https://filmajah.rogerferdinan.com/";
     //   holder.tvNama.setText(movieList.get(position).name);
        Picasso.get()
                .load(base_url+movieList.get(position).image_url)
                .placeholder(R.drawable.profile);
            //    .into(holder.ivMovie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
