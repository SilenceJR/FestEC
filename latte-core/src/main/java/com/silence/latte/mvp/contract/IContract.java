package com.silence.latte.mvp.contract;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface IContract {
    interface IModel {

    }

    interface IView {
        void addDisposable(Disposable d);
        void onError(int errorCode, String errorMsg);
        void showLoading();
        void hideLoading();

    }

    interface IPresenter<V extends IView, M extends IModel> {
        V getView();
        void detachView();
    }
}
