package com.silence.latte.delegates

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.silence.latte.R

/**
 *
 *  @author:  PJ
 *  @time:    2018/7/5 / 18:10
 *
 */
abstract class BaseBackFragment: BaseSupportFragment() {

    abstract fun setLayout(): Any
    abstract fun initView(view: View, savedInstanceState: Bundle?)
    protected var mUbinder: Unbinder? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView: View? = null
        if (setLayout() is Int) {
            rootView = inflater.inflate(setLayout() as Int, container, false)
        } else if (setLayout() is View) {
            rootView = setLayout() as View
        } else{
            throw ClassCastException("type of setLayout() must be int or view!")
        }

        if (null != rootView) {
            mUbinder = ButterKnife.bind(this, rootView)
        }

        return rootView
    }

    fun initToolbar(toolbar: Toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { v -> pop() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (null != mUbinder) {
            mUbinder!!.unbind()
        }
    }



}