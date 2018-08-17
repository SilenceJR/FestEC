package com.silence.latte.ec.main.top;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.chrisbanes.photoview.PhotoView;
import com.silence.latte.delegates.BaseMvpSwipeFragment;
import com.silence.latte.ec.R;
import com.silence.latte.ec.R2;
import com.silence.latte.ec.adapter.GankioImageAdapter;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ec.mvp.contract.GankioImageContract;
import com.silence.latte.ec.mvp.model.GankioImageModelImpl;
import com.silence.latte.ec.mvp.presenter.GankioImagePresenterImpl;
import com.silence.latte.ui.buttom.BottomItemFragment;
import com.silence.latte.ui.photo.PhotoFragment;
import com.silence.latte.ui.top.BaseTopFragment;

import java.util.LinkedList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankioImageFragment extends BaseMvpSwipeFragment implements BaseQuickAdapter.RequestLoadMoreListener, GankioImageContract.View, BaseQuickAdapter.OnItemClickListener {

    @BindView(R2.id.recycler)
    RecyclerView mRecycler;
    private int mCount = 1;
    private boolean mFlag = true;

    private GankioImageAdapter mAdapter;
    private GankioImagePresenterImpl mPresenter;


    public static GankioImageFragment newInstance() {

        Bundle args = new Bundle();

        GankioImageFragment fragment = new GankioImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_gankio_image;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new GankioImagePresenterImpl(this, new GankioImageModelImpl());
        initRecycler();
        initData();
    }

    private void initData() {
        mPresenter.getImage(mCount);
    }

    private void initRecycler() {
        mRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecycler.setHasFixedSize(true);
        mAdapter = new GankioImageAdapter(null);
        mAdapter.openLoadAnimation();
        mAdapter.setEnableLoadMore(true);
        mAdapter.setOnLoadMoreListener(this, mRecycler);
        mRecycler.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
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

    @Override
    public void onLoadMoreRequested() {
        initData();
    }

    @Override
    public void showImage(LinkedList<GankioImageBean> data) {
        if (null != data) {
            mCount++;
            if (mFlag) {
                mAdapter.setNewData(data);
                mFlag = false;
            } else {
                mAdapter.addData(data);
            }

            if (mAdapter.isLoading()) {
                mAdapter.loadMoreComplete();
            }

            if (!mAdapter.isLoadMoreEnable()) {
                mAdapter.setEnableLoadMore(true);
            }


        } else {
            if (mAdapter.isLoading()) {
                mAdapter.loadMoreFail();
            }
            mAdapter.setEnableLoadMore(true);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        GankioImageBean item = (GankioImageBean) adapter.getData().get(position);
        ImageView iv = view.findViewById(R.id.iv);
        PhotoFragment toFragment = PhotoFragment.newInstance(item.getUrl());
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            toFragment.setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
            setExitTransition(new Fade());
            toFragment.setSharedElementReturnTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
            ((AppTopFragment) getParentFragment()).extraTransaction()
                    .addSharedElement(iv, "image")
                    .start(toFragment);
        } else {
            ((AppTopFragment) getParentFragment()).start(toFragment);
        }
    }

}
