package com.silence.latte.ec.main.index;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silence.latte.delegates.BaseMvpSwipeFragment;
import com.silence.latte.ec.R;
import com.silence.latte.ui.buttom.BottomItemFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends BottomItemFragment {

    public static IndexFragment newInstance() {

        Bundle args = new Bundle();

        IndexFragment fragment = new IndexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }


    @Override
    public void onError(int errorCode, String errorMsg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
