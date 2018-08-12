package com.silence.latte.ec.mvp.contract;

import com.silence.latte.ec.bean.GankioAndroidBean;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.mvp.contract.IContract;

import java.util.LinkedList;

import io.reactivex.Observable;

public interface GankioAndroidContract {
    interface Model extends IContract.IModel{
        Observable<LinkedList<GankioAndroidBean>> getData(int page);
    }

    interface View extends IContract.IView{
        void showData(LinkedList<GankioAndroidBean> data);
    }

    interface Presenter extends IContract.IPresenter{
        void getData(int page);
    }
}
