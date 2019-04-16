package com.juliedai.android.movietrailers.presentation.presenter;

import android.util.Log;

import com.juliedai.android.movietrailers.data.MovieModel;
import com.juliedai.android.movietrailers.data.repository.Listener;
import com.juliedai.android.movietrailers.domain.interator.MoviesInteractor;
import com.juliedai.android.movietrailers.presentation.view.activity.list.Contract;

import java.util.List;

/**
 * @author  Julie Dai
 * TODO missing proper comments
 */

public class MoviesPresenterImpl implements Contract.Presenter{ //TODO missing space

    private static final String LOG_TAG = "_MoviesActivity_";
    private final MoviesInteractor interactor;
    private final Contract.View view;

    public MoviesPresenterImpl(Contract.View view) {
      //Move this to be a part of the constructor so you don't create a dependency
      this.interactor = new MoviesInteractor(view.getViewContext());
      this.view = view;

      loadData();
  }

    private void loadData(){//TODO missing space
      view.showLoading();
      this.interactor.retrieveMovies(new Listener<List<MovieModel>>() {
        @Override
        public void onSuccess(List<MovieModel> movieModels) {
          view.hideLoading(); //TODO This should be a part of the view not part of the presenter
          view.loadMovies(movieModels);
        }

        @Override
        public void onFailure() {
          view.hideLoading(); //TODO This should be a part of the view not part of the presenter
          view.onError();
        }
      });
    }

    @Override
    public void onMovieClicked(int position) {
      if (interactor.isItemPositionCorrect(position)) {
        view.openMovieDetails(position);
      }else{//TODO missing space
        Log.d(LOG_TAG, "> Presenter > onMovieClicked: Item position incorrect");
      }
    }

    @Override
    public void onMenuDeleteClicked() {
      view.clearAdapter();
    }

  @Override
  public void onMenuReloadClicked() {
    view.clearAdapter(); //TODO This should be a part of the view not part of the presenter
    loadData();
  }
}
