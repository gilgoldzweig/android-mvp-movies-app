package com.juliedai.android.movietrailers.presentation.presenter;

import com.juliedai.android.movietrailers.presentation.view.fragment.thread.Contract;

/**
 * @author  Julie Dai
 */

public class CounterFragmentPresenterImpl implements Contract.Presenter {
    private final Contract.View view;

    public CounterFragmentPresenterImpl(Contract.View view, String fragContent){
        this.view = view;

        this.view.setTaskStatus(fragContent);
    }
}
