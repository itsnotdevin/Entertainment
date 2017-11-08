package com.androidapplication.entertainmentmedia.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapplication.entertainmentmedia.Data.Movies;
import com.androidapplication.entertainmentmedia.R;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by ahmed on 11/7/2017.
 */

@SuppressWarnings("ConstantConditions")
public class MovieRecycleViewAdapter extends RecyclerView.Adapter<MovieRecycleViewAdapter.ViewHolder>{

    //Instance variables
    private Context context;
    private List<Movies> moviesList;

    public MovieRecycleViewAdapter(Context context, List<Movies> movies) {
        this.context = context;
        this.moviesList = movies;
    }

    @Override
    public MovieRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);


        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(MovieRecycleViewAdapter.ViewHolder holder, int position) {

        Movies movies = moviesList.get(position);

        holder.movieTitle.setText(movies.getTitle());
        holder.movieType.setText(movies.getMovieType());


        Picasso.with(context)
                .load(movies.getPoster())
                .placeholder(android.R.drawable.ic_media_play)
                .into( holder.moviePoster);

        holder.movieYear.setText(movies.getYear());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       private TextView movieTitle;
       private ImageView moviePoster;
       private TextView movieYear;
       private TextView movieType;

        public ViewHolder(View itemView, final Context ctx) {
            super(itemView);
            context = ctx;

            movieTitle = (TextView) itemView.findViewById(R.id.movieTitleTextView);
            moviePoster = (ImageView) itemView.findViewById(R.id.moviePosterImageView);
            movieYear = (TextView) itemView.findViewById(R.id.movieYearTextView);
            movieType = (TextView) itemView.findViewById(R.id.movieTypeTextView);

            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Row tapped", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
