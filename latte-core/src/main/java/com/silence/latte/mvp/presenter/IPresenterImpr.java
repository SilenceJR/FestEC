package com.silence.latte.mvp.presenter;

import com.silence.latte.mvp.contract.IContract;

import java.lang.ref.WeakReference;

public abstract class IPresenterImpr<V extends IContract.IView, M extends IContract.IModel> implements IContract.IPresenter {

    protected WeakReference<V> mWeakReference;
    protected M mModel;

    public IPresenterImpr(V view, M model) {
        mWeakReference = new WeakReference<>(view);
        mModel = model;
    }

    protected boolean isViewActive() {
        return mWeakReference != null && null != mWeakReference.get();
    }

    @Override
    public void detachView() {
        if (null != mWeakReference) {
            mWeakReference.clear();
            mWeakReference = null;
        }

        if (null != mModel) {
            mModel = null;
        }
    }

    @Override
    public V getView() {
        if (null != mWeakReference) {
            return mWeakReference.get();
        } else {
            return null;
        }
    }

}
