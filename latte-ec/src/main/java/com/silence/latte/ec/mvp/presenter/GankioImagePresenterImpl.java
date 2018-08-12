package com.silence.latte.ec.mvp.presenter;

import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ec.bean.GankioRespMsg;
import com.silence.latte.ec.mvp.contract.GankioImageContract;
import com.silence.latte.mvp.presenter.IPresenterImpr;
import com.silence.latte.net.callback.LatteObserver;

import java.util.LinkedList;

public class GankioImagePresenterImpl extends IPresenterImpr<GankioImageContract.View, GankioImageContract.Model> implements GankioImageContract.Presenter {

    public GankioImagePresenterImpl(GankioImageContract.View view, GankioImageContract.Model model) {
        super(view, model);
    }

    @Override
    public void getImage(int page) {
        mModel.getImage(page)
                .subscribe(new LatteObserver<LinkedList<GankioImageBean>>(getView()) {
                    @Override
                    public void onSuccess(LinkedList<GankioImageBean> gankioImageBeanGankioRespMsg) {
                        if (isViewActive()) {
                            getView().showImage(gankioImageBeanGankioRespMsg);
                        }
                    }
                });
    }
}
