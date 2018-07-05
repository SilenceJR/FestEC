package com.silence.latte.delegates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *
 *  @author:  PJ
 *  @time:    2018/7/5 / 18:10
 *
 */
abstract class BaseFragment: BaseSupportFragment() {

    abstract fun setLayout(): Any

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View? = null
        if (setLayout() is Int) {
            rootView = inflater.inflate(setLayout() as Int, container, false)
        } else if (setLayout() is View) {
            rootView = setLayout() as View
        }
        return rootView
    }


}