package com.juliedai.android.movietrailers.presentation.view.activity.list;

import android.content.Context;

import com.juliedai.android.movietrailers.data.MovieModel;

import java.util.List;

/**
 * @author  Julie Dai
 */

public interface Contract {
    interface View {
        //TODO who loads the movies and if this is movies loaded why is it not called onMoviesLoaded()
        void loadMovies(List<MovieModel> movies);

        void openMovieDetails(int position);

        void showLoading(); //TODO Remove

        void hideLoading(); //TODO Remove

        void clearAdapter(); //TODO Remove

        Context getViewContext();  //TODO Remove should not pass android elements to the presenter

        void onError(); //TODO what error?
    }

    interface Presenter {
        void onMovieClicked(int position);

        void onMenuDeleteClicked();

        void onMenuReloadClicked();
    }
    //TODO To much space
    //TODO To much space
}
