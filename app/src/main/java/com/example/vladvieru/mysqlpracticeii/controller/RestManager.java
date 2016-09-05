package com.example.vladvieru.mysqlpracticeii.controller;

import com.example.vladvieru.mysqlpracticeii.model.callback.FilmService;
import com.example.vladvieru.mysqlpracticeii.model.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vladvieru on 7/20/16.
 */
public class RestManager {

    private FilmService mFilmService;

    public FilmService getmFilmService(){
        if(mFilmService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFilmService = retrofit.create(FilmService.class);
        }
        return  mFilmService;
    }
}
