package com.example.vladvieru.mysqlpracticeii.model.adapter;

import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.vladvieru.mysqlpracticeii.R;
import com.example.vladvieru.mysqlpracticeii.model.Film;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Settings.System.AIRPLANE_MODE_ON;
import static android.provider.Settings.System.getConfiguration;

/**
 * Created by vladvieru on 7/20/16.
 */
public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.Holder> {

    private static final String TAG=FilmAdapter.class.getSimpleName();
    private final FilmClickListener mListener;
    private List<Film> mFilms;

    public FilmAdapter(FilmClickListener listener){
        mFilms = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,null,false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final Film currFilm = mFilms.get(position);
        holder.mName.setText(currFilm.getName());
        //holder.mPrice.setText("$" + Double.toString(currFilm.getPrice()));
        holder.mInstruction.setText(currFilm.getInstructions());
        //holder.mShortinfo.setText(currFilm.getShortinfo());
        Picasso.with(holder.itemView.getContext()).load("http://192.168.0.89/photos/" + currFilm.getPhoto()).into(holder.mPhoto);

    }

    @Override
    public int getItemCount() {
        return mFilms.size();
    }

    public void addFilm(Film film) {
        Log.d(TAG,film.getPhoto());
        mFilms.add(film);
        notifyDataSetChanged();
    }

    public Film getSelectedFilm(int position) {
        return mFilms.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private ImageView mPhoto;
        private TextView mName;

        //private TextView mPrice;

        private TextView mInstruction;
        //private TextView mShortinfo;


        public Holder(View itemView) {
            super(itemView);
            mPhoto=(ImageView)itemView.findViewById(R.id.filmPhoto);
            mName=(TextView)itemView.findViewById(R.id.filmName);

            //mPrice=(TextView)itemView.findViewById(R.id.filmPrice);


            mInstruction = (TextView)itemView.findViewById(R.id.filmInstruction);
            //mShortinfo=(TextView)itemView.findViewById(R.id.filmShortinfo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(getLayoutPosition());

        }
    }
    public interface FilmClickListener{
        void onClick(int position);
    }

    static boolean isAirplaneModeOn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }
}
