package com.silence.latte.ui.photo;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.TransitionInflater;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.silence.latte.R;
import com.silence.latte.R2;
import com.silence.latte.delegates.BaseMvpSwipeFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoFragment extends BaseMvpSwipeFragment {

    @BindView(R2.id.photo_view)
    PhotoView mPhotoView;

    public static PhotoFragment newInstance(String url) {

        Bundle args = new Bundle();

        args.putString("url", url);
        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_photo;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(
                    TransitionInflater.from(getContext())
                            .inflateTransition(android.R.transition.move)
            );
        }

        String url = getArguments().getString("url");
        Glide.with(this)
                .load(url)
                .into(mPhotoView);


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
