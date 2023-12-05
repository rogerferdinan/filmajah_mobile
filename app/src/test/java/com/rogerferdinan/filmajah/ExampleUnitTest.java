package com.rogerferdinan.filmajah;

import org.junit.Test;

import com.rogerferdinan.filmajah.model.Movie;
import com.rogerferdinan.filmajah.model.retrofit.APIClient;
import com.rogerferdinan.filmajah.model.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void apiConnectionTest() {
        ApiService apiInterface = new APIClient().getApi();
        Call<List<Movie>> call = apiInterface.getMovieList();
        try {
            Response<List<Movie>> response = call.execute();
            for (Movie movie: response.body()) {
                System.out.println(movie.name.toString());
            }
        } catch(Exception e) {

        }
    }
}