package com.silence.latte.ec.main.top;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.silence.latte.delegates.BaseMvpSwipeFragment;
import com.silence.latte.ec.R;
import com.silence.latte.ec.R2;
import com.silence.latte.ec.adapter.GankioAndroidAdapter;
import com.silence.latte.ec.adapter.GankioImageAdapter;
import com.silence.latte.ec.bean.GankioAndroidBean;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ec.mvp.contract.GankioAndroidContract;
import com.silence.latte.ec.mvp.contract.GankioImageContract;
import com.silence.latte.ec.mvp.model.GankioAndroidModelImpl;
import com.silence.latte.ec.mvp.model.GankioImageModelImpl;
import com.silence.latte.ec.mvp.presenter.GankioAndroidPresenterImpl;
import com.silence.latte.ec.mvp.presenter.GankioImagePresenterImpl;

import java.util.LinkedList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankioAndroidFragment extends BaseMvpSwipeFragment implements BaseQuickAdapter.RequestLoadMoreListener, GankioAndroidContract.View, BaseQuickAdapter.OnItemClickListener {

    @BindView(R2.id.recycler)
    RecyclerView mRecycler;
    private int mCount = 1;
    private boolean mFlag = true;

    private GankioAndroidAdapter mAdapter;
    private GankioAndroidPresenterImpl mPresenter;


    public static GankioAndroidFragment newInstance() {

        Bundle args = new Bundle();

        GankioAndroidFragment fragment = new GankioAndroidFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_gankio_image;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mPresenter = new GankioAndroidPresenterImpl(this, new GankioAndroidModelImpl());
        initRecycler();
        initData();
    }

    private void initData() {
        mPresenter.getData(mCount);
    }

    private void initRecycler() {
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setHasFixedSize(true);
        mAdapter = new GankioAndroidAdapter(null);
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
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void showData(LinkedList<GankioAndroidBean> data) {
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
}
