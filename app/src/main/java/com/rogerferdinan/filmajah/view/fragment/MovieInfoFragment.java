package com.rogerferdinan.filmajah.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rogerferdinan.filmajah.R;

public class MovieInfoFragment extends Fragment {
    public MovieInfoFragment() {
        super(R.layout.movie_info);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageButton ibBackButton = view.findViewById(R.id.ibBackButton);
        TextView tvMovieName = view.findViewById(R.id.movieTitle);
        TextView tvRatings = view.findViewById(R.id.ratings);
        TextView tvReleasedYear = view.findViewById(R.id.releasedYear);
        TextView tvMovieLength = view.findViewById(R.id.movieLength);
        TextView tvMovieGenre = view.findViewById(R.id.movieGenre);
        TextView tvProducer = view.findViewById(R.id.producerName);
        TextView tvCast = view.findViewById(R.id.castName);
        TextView tvSynopsis = view.findViewById(R.id.synopsisText);
        ImageButton ibAddToCollection = view.findViewById(R.id.addToCollection);

        tvMovieName.setText("Rubicon");
        tvRatings.setText("3.5");
        tvReleasedYear.setText("2023");
        tvMovieLength.setText("120");
        tvMovieGenre.setText("Thriller, Crime");
        tvProducer.setText("Trisambo");
        tvCast.setText("Mario Dandy");
        tvSynopsis.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a odio id ante cursus iaculis. Quisque nec tellus et eros iaculis venenatis ac et tortor. Sed rutrum nunc massa, ac pretium elit mollis non. Proin semper nisl nulla, eu interdum nisl feugiat nec. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas pharetra imperdiet urna eget tempus. Interdum et malesuada fames ac ante ipsum primis in faucibus.");
    }
}
