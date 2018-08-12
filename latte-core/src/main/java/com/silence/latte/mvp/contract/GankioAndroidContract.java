package com.silence.latte.mvp.contract;

import io.reactivex.Observable;

public interface GankioAndroidContract {
    interface Model extends IContract.IModel {
        Observable<String> getData(int page);
    }

    interface View extends IContract.IView{
        void showData(String s);
    }

    interface Presenter extends IContract.IPresenter{
        void getData(int page);
    }
}
