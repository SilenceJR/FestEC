package com.silence.festec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.silence.latte.app.Latte;
import com.silence.latte.delegates.LatteDelegate;
import com.silence.latte.net.RestClient;
import com.silence.latte.net.RestClientBuilder;
import com.silence.latte.net.RestCreator;
import com.silence.latte.net.callback.IError;
import com.silence.latte.net.callback.IFailure;
import com.silence.latte.net.callback.IRequest;
import com.silence.latte.net.callback.ISuccess;
import com.silence.latte.net.rx.RxRestClient;

import java.util.WeakHashMap;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AppDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_app;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient2();
    }

    private void testRestClient() {

        RxRestClient.builder()
                .url("")
                .params("", "")
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(Latte.getApplication(), s, Toast.LENGTH_LONG).show();
                        Log.d("http", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

//        RestClient.builder()
//                .url("www.baidu.com")
//                .params("", "")
//                .success(new ISuccess() {
//                    @Override
//                    public void onSuccess(String response) {
//
//                    }
//                })
//                .failure(new IFailure() {
//                    @Override
//                    public void onFailure() {
//
//                    }
//                })
//                .error(new IError() {
//                    @Override
//                    public void onError(int code, String msg) {
//
//                    }
//                })
//                .build();
    }

    private void testRestClient2() {


        RestCreator.getRxRestServiceHolder()
                .get("http://www.baidu.com", new WeakHashMap<String, Object>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(Latte.getApplication(), s, Toast.LENGTH_LONG).show();
                        Log.d("http", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
