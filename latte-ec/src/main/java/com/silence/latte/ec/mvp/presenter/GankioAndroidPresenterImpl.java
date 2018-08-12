package com.silence.latte.ec.mvp.presenter;

import com.silence.latte.ec.bean.GankioAndroidBean;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ec.mvp.contract.GankioAndroidContract;
import com.silence.latte.mvp.contract.IContract;
import com.silence.latte.mvp.presenter.IPresenterImpr;
import com.silence.latte.net.callback.LatteObserver;

import java.util.LinkedList;

public class GankioAndroidPresenterImpl extends IPresenterImpr<GankioAndroidContract.View, GankioAndroidContract.Model> implements GankioAndroidContract.Presenter {

    public GankioAndroidPresenterImpl(GankioAndroidContract.View view, GankioAndroidContract.Model model) {
        super(view, model);
    }

    @Override
    public void getData(int page) {
        mModel.getData(page)
        .subscribe(new LatteObserver<LinkedList<GankioAndroidBean>>(getView()) {
            @Override
            public void onSuccess(LinkedList<GankioAndroidBean> gankioAndroidBean) {
                if (isViewActive()) {
                    getView().showData(gankioAndroidBean);
                }
            }
        });
    }
}
