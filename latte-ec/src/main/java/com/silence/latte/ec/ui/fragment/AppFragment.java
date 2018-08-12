package com.silence.latte.ec.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.silence.latte.ec.R;
import com.silence.latte.ec.R2;
import com.silence.latte.ec.bean.GankioAndroidBean;
import com.silence.latte.ec.mvp.contract.GankioAndroidContract;
import com.silence.latte.ec.mvp.model.GankioAndroidModelImpl;
import com.silence.latte.ec.mvp.presenter.GankioAndroidPresenterImpl;
import com.silence.latte.net.RestCreator;
import com.silence.latte.ui.LatteLoader;
import com.silence.latte.ui.LoaderStyle;
import com.silence.latte.ui.buttom.BottomItemFragment;

import java.util.LinkedList;
import java.util.WeakHashMap;

import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AppFragment extends BottomItemFragment implements GankioAndroidContract.View {


    private GankioAndroidPresenterImpl mPresenter;

    @OnClick(R2.id.btn)
    public void onViewClicked() {
//        testRestClient2();
        mPresenter.getData(1);
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_app;
    }

    public static AppFragment newInstance() {

        Bundle args = new Bundle();

        AppFragment fragment = new AppFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
//        testRestClient2();
        mPresenter = new GankioAndroidPresenterImpl(this, new GankioAndroidModelImpl());

//        mPresenter.getData(1);

        FragmentManager fm = getFragmentManager();
//        fm.beginTransaction().replace(R.id.comm_fragment, gankioFragment).commit();
    }


    private void testRestClient2() {
//        LatteLoader.showLoading(getContext(), LoaderStyle.PacmanIndicator.name());
        LatteLoader.showLoadingDelayedStop(getContext(), LoaderStyle.PacmanIndicator.name(), 3000);

        RestCreator.getRxRestService()
                .get("http://gank.io/api/data/Android/10/1", new WeakHashMap<String, Object>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
//                        Toast.makeText(Latte.getApplication(), s, Toast.LENGTH_LONG).show();
                        Log.d("http", s);

                    }

                    @Override
                    public void onError(Throwable e) {
//                        Toast.makeText(Latte.getApplication(), e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("http", e.getMessage());
//                        onNetFinish();
                    }

                    @Override
                    public void onComplete() {
//                        onNetFinish();
                    }
                });
    }


    @Override
    public void onError(int errorCode, String errorMsg) {
        Log.d("app", errorMsg);
    }

    @Override
    public void showLoading() {
        LatteLoader.showLoading(getContext());
    }

    @Override
    public void hideLoading() {
        LatteLoader.stopLoading();
    }

    @Override
    public void showData(LinkedList<GankioAndroidBean> data) {

    }
}
