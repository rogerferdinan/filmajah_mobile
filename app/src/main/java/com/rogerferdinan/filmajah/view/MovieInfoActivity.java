package com.rogerferdinan.filmajah.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.rogerferdinan.filmajah.R;
import com.rogerferdinan.filmajah.model.LoginBody;
import com.rogerferdinan.filmajah.model.retrofit.APIClient;
import com.rogerferdinan.filmajah.model.retrofit.ApiService;
import com.rogerferdinan.filmajah.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.user = new LoginBody(
                getIntent().getStringExtra("email"),
                getIntent().getStringExtra("password")
        );

        ImageButton ibBack = findViewById(R.id.ibBackButton);
        TextView tvMovieName = findViewById(R.id.movieTitle);
        TextView tvRatings = findViewById(R.id.tvRating);
        TextView tvReleasedYear = findViewById(R.id.tvYear);
        TextView tvMovieLength = findViewById(R.id.tvLength);
        TextView tvMovieGenre = findViewById(R.id.tvGenre);
        TextView tvProducer = findViewById(R.id.tvProducer);
        TextView tvCast = findViewById(R.id.tvCast);
        TextView tvSynopsis = findViewById(R.id.synopsisText);
        ImageButton ibAddToCollection = findViewById(R.id.addToCollection);
        ImageView imageView = findViewById(R.id.moviePoster);

        Intent intent = getIntent();
        String movie_name = intent.getStringExtra("movie_name");

        viewModel.getMovieInfo(movie_name, viewModel.user.email).observe(MovieInfoActivity.this, movie_info -> {
            if(movie_info != null) {
                tvMovieName.setText(movie_info.movie_name);
                tvRatings.setText(movie_info.rating.toString()+ " / 10");
                tvMovieLength.setText(movie_info.length.toString()+ " minute(s)");
                tvReleasedYear.setText(movie_info.release_year.toString());
                tvProducer.setText(movie_info.producer_name);
                tvSynopsis.setText(movie_info.synopsis);

                String genre = "";
                if(movie_info.genres != null) {
                    for(int i=0; i<movie_info.genres.size(); i++) {
                        if(genre != "") {
                            genre += "| ";
                        }
                        genre += movie_info.genres.get(i);
                    }
                }
                tvMovieGenre.setText(genre);

                String cast = "";
                if(movie_info.casts != null) {
                    for(int i=0; i<movie_info.casts.size(); i++) {
                        if(cast != "") {
                            cast += "| ";
                        }
                        cast += movie_info.casts.get(i);
                    }
                }
                tvCast.setText(cast);

                Picasso.get().load(APIClient.BASE_URL+"/"+movie_info.image_url)
                        .placeholder(R.drawable.rubicon)
                        .into(imageView);
            }
        });

        ibAddToCollection.setOnClickListener(view -> {
            viewModel.addCollection(movie_name).observe(MovieInfoActivity.this, is_success -> {
                if(is_success) {
                    Toast.makeText(getApplicationContext(), "Success to add new collection", Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to add collection", Toast.LENGTH_LONG);
                }
            });
        });
        ibBack.setOnClickListener(view -> {
            finish();
        });
    }
}
