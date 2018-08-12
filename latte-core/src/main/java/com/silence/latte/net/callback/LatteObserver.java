package com.silence.latte.net.callback;

import android.os.NetworkOnMainThreadException;
import android.support.annotation.Nullable;

import com.silence.latte.mvp.contract.IContract;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class LatteObserver<T> implements Observer<T> {

    private final String TAG = LatteObserver.class.getSimpleName();
    private int ERROR_CODE = -1;
    private String ERROR_MSG = "未知的错误！";

    public abstract void onSuccess(T t);
    private final IContract.IView mView;

    public LatteObserver(IContract.IView view) {
        mView = view;
        mView.showLoading();
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (null != mView) {
            mView.addDisposable(d);
        }
    }

    @Override
    public void onNext(T t) {
        if (null != t) {
            onSuccess(t);
        } else {
            onError(-1, "未知错误");
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            ERROR_MSG = "服务器响应超时";
        } else if (e instanceof ConnectException) {
            ERROR_MSG = "网络连接异常，请检查网络";
        } else if (e instanceof UnknownHostException) {
            ERROR_MSG = "无法解析主机，请检查网络连接";
        } else if (e instanceof UnknownServiceException) {
            ERROR_MSG = "未知的服务器错误";
            //飞行模式等
        } else if (e instanceof IOException) {
            ERROR_MSG = "没有网络，请检查网络连接";
            //主线程不能网络请求，这个很容易发现
        } else if (e instanceof NetworkOnMainThreadException) {
            ERROR_MSG = "主线程不能网络请求";
            //很多的错误都是extends RuntimeException
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ERROR_CODE = httpException.code();
            ERROR_MSG = httpException.getMessage();
        } else if (e instanceof RuntimeException) {
            ERROR_MSG = "运行错误";
        }
        onError(ERROR_CODE, ERROR_MSG);
    }
    
    public void onError(int error_code, String error_msg) {
        if (null != mView) {
            mView.onError(error_code, error_msg);
        }
        onNetFinish();
    }

    @Override
    public void onComplete() {
        onNetFinish();
    }
    
    public void onNetFinish() {
        if (null != mView) {
            mView.hideLoading();
        }
    }
}
