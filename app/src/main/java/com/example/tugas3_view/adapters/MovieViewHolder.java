package com.example.tugas3_view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas3_view.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title,tagline,releaseDate,rating;
    ImageView poster;
    LinearLayout dotsLayout;

    OnMovieListener onMovieListener;

    public MovieViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);
        this.onMovieListener = onMovieListener;

        title = itemView.findViewById(R.id.title);
//        tagline = itemView.findViewById(R.id.tagline);
        releaseDate = itemView.findViewById(R.id.releaseDate);
        rating = itemView.findViewById(R.id.ratingText);
        poster = itemView.findViewById(R.id.poster);
        dotsLayout = itemView.findViewById(R.id.dots);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onMovieListener.onMovieClick(getPosition());
    }
}
