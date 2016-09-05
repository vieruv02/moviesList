package com.example.vladvieru.mysqlpracticeii.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vladvieru.mysqlpracticeii.R;
import com.example.vladvieru.mysqlpracticeii.model.Film;
import com.example.vladvieru.mysqlpracticeii.model.helper.Constants;
import com.squareup.picasso.Picasso;
import static android.provider.Settings.System.AIRPLANE_MODE_ON;

/**
 * Created by vladvieru on 7/20/16.
 */
public class DetailActivity extends AppCompatActivity {

    private ImageView mPhoto;
    private TextView mName, mId, mCategory, mInstruction,mPrice;
    //private TextView mShortinfo;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Film film = (Film) intent.getSerializableExtra(Constants.REFERENCE.FILM);
        configViews();

        mId.setText(""+film.getProductId());
        mName.setText(film.getName());
        mCategory.setText(film.getCategory());
        mInstruction.setText(film.getInstructions());
        //mShortinfo.setText(film.getShortinfo());

        Picasso.with(getApplicationContext()).load("http://192.168.0.89/photos/" + film.getPhoto()).into(mPhoto);
    }
    private void configViews(){
        mPhoto = (ImageView)findViewById(R.id.filmPhoto);
        mName = (TextView)findViewById(R.id.filmName);
        mId = (TextView)findViewById(R.id.filmId);
        mCategory = (TextView)findViewById(R.id.filmCategory);
        mInstruction = (TextView)findViewById(R.id.filmInstruction);
        //mShortinfo = (TextView)findViewById(R.id.filmShortinfo);
        mPrice = (TextView)findViewById(R.id.filmPrice);

    }

    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }
}
