package com.silence.latte.ec.mvp.contract;

import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ec.bean.GankioRespMsg;
import com.silence.latte.mvp.contract.IContract;

import java.util.LinkedList;

import io.reactivex.Observable;
import io.reactivex.Observer;

public interface GankioImageContract {
    interface Model extends IContract.IModel{
        Observable<LinkedList<GankioImageBean>> getImage(int page);
    }

    interface View extends IContract.IView{
        void showImage(LinkedList<GankioImageBean> data);
    }

    interface Presenter extends IContract.IPresenter{
        void getImage(int page);
    }
}
