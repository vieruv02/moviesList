package com.example.vladvieru.mysqlpracticeii.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.vladvieru.mysqlpracticeii.R;
import com.example.vladvieru.mysqlpracticeii.controller.RestManager;
import com.example.vladvieru.mysqlpracticeii.model.Film;
import com.example.vladvieru.mysqlpracticeii.model.adapter.FilmAdapter;
import com.example.vladvieru.mysqlpracticeii.model.helper.Constants;
import com.mikepenz.materialdrawer.DrawerBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;


public class MainActivity extends AppCompatActivity implements FilmAdapter.FilmClickListener, NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private FilmAdapter mFilmAdapter;

    //nav Draw
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();

        //nav Draw
        //


        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        mManager = new RestManager();
        Call<List<Film>> listCall = mManager.getmFilmService().getAllFilms();
        listCall.enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {

                if(response.isSuccessful()){
                    List<Film>filmList = response.body();

                    for(int i =0;i<filmList.size();i++){
                        Film film = filmList.get(i);
                        mFilmAdapter.addFilm(film);
                    }


                }
                else{
                    int sc = response.code();
                    switch (sc){

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {

            }
        });
    }

    private void configViews() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        mFilmAdapter = new FilmAdapter(this);

        mRecyclerView.setAdapter(mFilmAdapter);
    }

    @Override
    public void onClick(int position) {
        Film selectedFilm = mFilmAdapter.getSelectedFilm(position);
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.FILM, selectedFilm);
        startActivity(intent);
        //YoYo.with(Techniques.FadeIn).playOn(findViewById(R.id.cardview));

    }

    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    //nav Draw

    //
}
