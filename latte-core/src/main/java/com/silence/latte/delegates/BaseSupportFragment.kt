package com.silence.latte.delegates

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SupportFragmentDelegate
import me.yokeyword.fragmentation.SupportHelper
import me.yokeyword.fragmentation.anim.FragmentAnimator

/**
 *
 *  @author:  PJ
 *  @time:    2018/7/5 / 17:45
 *
 */
open class BaseSupportFragment:Fragment(), ISupportFragment {

    val DELEGATE: SupportFragmentDelegate = SupportFragmentDelegate(this@BaseSupportFragment)
    protected lateinit var mActivity: FragmentActivity

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        DELEGATE.onAttach(activity)
        mActivity = DELEGATE.activity
    }

    override fun setFragmentResult(resultCode: Int, bundle: Bundle?) {
        DELEGATE.setFragmentResult(resultCode, bundle)
    }

    override fun onSupportInvisible() {
        DELEGATE.onSupportInvisible()
    }

    override fun onNewBundle(args: Bundle?) {
        DELEGATE.onNewBundle(args)
    }

    override fun extraTransaction(): ExtraTransaction {
        return DELEGATE.extraTransaction()
    }

    override fun onCreateFragmentAnimator(): FragmentAnimator {
        return DELEGATE.onCreateFragmentAnimator()
    }

    override fun enqueueAction(runnable: Runnable?) {
        DELEGATE.enqueueAction { runnable }
    }

    override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle?) {
        DELEGATE.onFragmentResult(requestCode, resultCode, data)
    }

    override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator?) {
        DELEGATE.fragmentAnimator = fragmentAnimator
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        DELEGATE.onLazyInitView(savedInstanceState)
    }

    override fun getFragmentAnimator(): FragmentAnimator {
        return DELEGATE.fragmentAnimator
    }

    override fun isSupportVisible(): Boolean {
        return DELEGATE.isSupportVisible
    }

    override fun onEnterAnimationEnd(savedInstanceState: Bundle?) {
        DELEGATE.onEnterAnimationEnd(savedInstanceState)
    }

    override fun onSupportVisible() {
        DELEGATE.onSupportVisible()
    }

    override fun onBackPressedSupport(): Boolean {
        return DELEGATE.onBackPressedSupport()
    }

    override fun getSupportDelegate(): SupportFragmentDelegate {
        return DELEGATE
    }

    override fun putNewBundle(newBundle: Bundle?) {
        DELEGATE.putNewBundle(newBundle)
    }

    override fun post(runnable: Runnable?) {
        DELEGATE.post(runnable)
    }

    override fun onResume() {
        super.onResume()
        DELEGATE.onResume()
    }

    override fun onPause() {
        super.onPause()
        DELEGATE.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        DELEGATE.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        DELEGATE.onDestroy()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        DELEGATE.onHiddenChanged(hidden)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        DELEGATE.setUserVisibleHint(isVisibleToUser)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        DELEGATE.onSaveInstanceState(outState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        DELEGATE.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DELEGATE.onCreate(savedInstanceState)
    }

    /****************************************以下为可选方法(Optional methods)******************************************************/
    // 自定制Support时，可移除不必要的方法

    /**
     * 隐藏软键盘
     */
    protected fun hideSoftInput() {
        DELEGATE.hideSoftInput()
    }

    /**
     * 显示软键盘,调用该方法后,会在onPause时自动隐藏软键盘
     */
    protected fun showSoftInput(view: View) {
        DELEGATE.showSoftInput(view)
    }

    /**
     * 加载根Fragment, 即Activity内的第一个Fragment 或 Fragment内的第一个子Fragment
     *
     * @param containerId 容器id
     * @param toFragment  目标Fragment
     */
    fun loadRootFragment(containerId: Int, toFragment: ISupportFragment) {
        DELEGATE.loadRootFragment(containerId, toFragment)
    }

    fun loadRootFragment(containerId: Int, toFragment: ISupportFragment, addToBackStack: Boolean, allowAnim: Boolean) {
        DELEGATE.loadRootFragment(containerId, toFragment, addToBackStack, allowAnim)
    }

    fun start(toFragment: ISupportFragment) {
        DELEGATE.start(toFragment)
    }

    /**
     * @param launchMode Similar to Activity's LaunchMode.
     */
    fun start(toFragment: ISupportFragment, @ISupportFragment.LaunchMode launchMode: Int) {
        DELEGATE.start(toFragment, launchMode)
    }

    /**
     * Launch an fragment for which you would like a result when it poped.
     */
    fun startForResult(toFragment: ISupportFragment, requestCode: Int) {
        DELEGATE.startForResult(toFragment, requestCode)
    }

    /**
     * Start the target Fragment and pop itself
     */
    fun startWithPop(toFragment: ISupportFragment) {
        DELEGATE.startWithPop(toFragment)
    }

    /**
     * @see .popTo
     * @see .start
     */
    fun startWithPopTo(toFragment: ISupportFragment, targetFragmentClass: Class<*>, includeTargetFragment: Boolean) {
        DELEGATE.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment)
    }

    fun replaceFragment(toFragment: ISupportFragment, addToBackStack: Boolean) {
        DELEGATE.replaceFragment(toFragment, addToBackStack)
    }

    fun pop() {
        DELEGATE.pop()
    }

    /**
     * Pop the last fragment transition from the manager's fragment
     * back stack.
     *
     *
     * 出栈到目标fragment
     *
     * @param targetFragmentClass   目标fragment
     * @param includeTargetFragment 是否包含该fragment
     */
    fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean) {
        DELEGATE.popTo(targetFragmentClass, includeTargetFragment)
    }

    /**
     * 获取栈内的fragment对象
     */
    fun <T : ISupportFragment> findChildFragment(fragmentClass: Class<T>): T {
        return SupportHelper.findFragment(childFragmentManager, fragmentClass)
    }
}