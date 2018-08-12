package com.silence.latte.delegates;


import android.os.Bundle;

import com.silence.latte.mvp.contract.IContract;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseMvpSwipeFragment extends LatteFragment  implements IContract.IView{

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void addDisposable(Disposable d) {
        mCompositeDisposable.add(d);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mCompositeDisposable.clear();
    }

}
