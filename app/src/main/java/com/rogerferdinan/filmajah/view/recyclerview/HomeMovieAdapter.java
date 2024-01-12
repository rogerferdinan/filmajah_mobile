package com.rogerferdinan.filmajah.view.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.model.MovieInfo;
import com.rogerferdinan.filmajah.model.retrofit.APIClient;
import com.rogerferdinan.filmajah.view.MovieInfoActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeMovieAdapter extends RecyclerView.Adapter<HomeMovieAdapter.ViewHolder> {
    private List<Movie> movieList;
    private Activity activity;
    private LoginBody user;

    public HomeMovieAdapter(List<Movie> movieList, LoginBody loginBody, Activity activity) {
        this.movieList = movieList;
        this.activity = activity;
        this.user = loginBody;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama;
        private ImageView ivMovie;
        private TextView tvRating;
        public ViewHolder(View v) {
            super(v);
             tvNama = (TextView) v.findViewById(R.id.tvNama);
             tvRating = (TextView) v.findViewById(R.id.tvRating);
             ivMovie = (ImageView) v.findViewById(R.id.ivMovie);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie current_movie = movieList.get(position);
        holder.tvNama.setText(current_movie.name);
        holder.tvRating.setText(current_movie.rating+" / 10");
        Picasso.get()
                .load(APIClient.BASE_URL + "/" + current_movie.image_url)
                .placeholder(R.drawable.rubicon)
                .into(holder.ivMovie, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.ivMovie.setOnClickListener(view -> {
                            Intent intent = new Intent(activity, MovieInfoActivity.class);
                            intent.putExtra("movie_name", current_movie.name);
                            intent.putExtra("email", user.email);
                            intent.putExtra("password", user.password);
                            activity.startActivity(intent);
                        });
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
