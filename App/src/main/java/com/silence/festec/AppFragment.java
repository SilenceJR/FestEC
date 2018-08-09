package com.silence.festec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.silence.latte.app.Latte;
import com.silence.latte.delegates.LatteFragment;
import com.silence.latte.net.RestCreator;
import com.silence.latte.net.rx.RxRestClient;

import java.util.WeakHashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AppFragment extends LatteFragment {


    @Override
    public Object setLayout() {
        return R.layout.delegate_app;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient2();



        FragmentManager fm = getFragmentManager();
//        fm.beginTransaction().replace(R.id.comm_fragment, gankioFragment).commit();




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
                        Toast.makeText(Latte.getApplication(), s, Toast.LENGTH_LONG).show();
                        Log.d("http", s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Latte.getApplication(), e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("http", e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
