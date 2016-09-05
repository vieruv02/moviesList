package com.example.vladvieru.mysqlpracticeii.model.callback;

import com.example.vladvieru.mysqlpracticeii.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vladvieru on 7/20/16.
 */
public interface FilmService {
    @GET("/json/films.json")
    Call<List<Film>> getAllFilms();
}
