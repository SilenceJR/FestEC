package com.silence.latte.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportActivity
import me.yokeyword.fragmentation.SupportActivityDelegate
import me.yokeyword.fragmentation.anim.FragmentAnimator
import retrofit2.http.DELETE
import me.yokeyword.fragmentation.SupportHelper
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SupportFragment



open class BaseSupportActivity: AppCompatActivity(), ISupportActivity {

    val DELEGATE: SupportActivityDelegate = SupportActivityDelegate(this@BaseSupportActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DELEGATE.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        DELEGATE.onPostCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        DELEGATE.onDestroy()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return DELEGATE.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev)
    }

    override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator?) {
        DELEGATE.fragmentAnimator = fragmentAnimator
    }

    override fun getFragmentAnimator(): FragmentAnimator {
        return DELEGATE.fragmentAnimator
    }

    override fun onBackPressedSupport() {
        DELEGATE.onBackPressedSupport()
    }

    override fun extraTransaction(): ExtraTransaction {
        return DELEGATE.extraTransaction()
    }

    override fun onCreateFragmentAnimator(): FragmentAnimator {
        return DELEGATE.onCreateFragmentAnimator()
    }

    override fun getSupportDelegate(): SupportActivityDelegate {
        return DELEGATE
    }

    override fun post(runnable: Runnable?) {
        DELEGATE.post(runnable)
    }

    /****************************************以下为可选方法(Optional methods) */

    // 选择性拓展其他方法

    fun loadRootFragment(containerId: Int, @NonNull toFragment: ISupportFragment) {
        DELEGATE.loadRootFragment(containerId, toFragment)
    }

    fun start(toFragment: ISupportFragment) {
        DELEGATE.start(toFragment)
    }

    /**
     * @param launchMode Same as Activity's LaunchMode.
     */
    fun start(toFragment: ISupportFragment, @ISupportFragment.LaunchMode launchMode: Int) {
        DELEGATE.start(toFragment, launchMode)
    }

    /**
     * It is recommended to use [SupportFragment.startWithPopTo].
     *
     * @see .popTo
     * @see .start
     */
    fun startWithPopTo(toFragment: ISupportFragment, targetFragmentClass: Class<*>, includeTargetFragment: Boolean) {
        DELEGATE.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment)
    }

    /**
     * Pop the fragment.
     */
    fun pop() {
        DELEGATE.pop()
    }

    /**
     * Pop the last fragment transition from the manager's fragment
     * back stack.
     */
    fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean) {
        DELEGATE.popTo(targetFragmentClass, includeTargetFragment)
    }

    /**
     * If you want to begin another FragmentTransaction immediately after popTo(), use this method.
     * 如果你想在出栈后, 立刻进行FragmentTransaction操作，请使用该方法
     */
    fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean, afterPopTransactionRunnable: Runnable) {
        DELEGATE.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable)
    }

    fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean, afterPopTransactionRunnable: Runnable, popAnim: Int) {
        DELEGATE.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable, popAnim)
    }

    /**
     * 得到位于栈顶Fragment
     */
    fun getTopFragment(): ISupportFragment {
        return SupportHelper.getTopFragment(supportFragmentManager)
    }

    /**
     * 获取栈内的fragment对象
     */
    fun <T : ISupportFragment> findFragment(fragmentClass: Class<T>): T {
        return SupportHelper.findFragment(supportFragmentManager, fragmentClass)
    }
    
}