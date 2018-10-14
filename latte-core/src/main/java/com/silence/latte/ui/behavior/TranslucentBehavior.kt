package com.silence.latte.ui.behavior

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.View
import com.silence.latte.R

class TransluncentBehavior(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<Toolbar>(context, attrs) {

    //顶部距离
    private var mDistanceY = 0

    companion object {
        private val SHOW_SPEED = 3
    }



    override fun layoutDependsOn(parent: CoordinatorLayout?, child: Toolbar?, dependency: View): Boolean {
        return dependency.id == R.id.view_page
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: Toolbar, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return true
    }


    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: Toolbar, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)

        Build.VERSION.SDK_INT > Build.VERSION_CODES.N

        mDistanceY += dy
        val targetHeight = child.bottom
        if (mDistanceY > 0 && mDistanceY < targetHeight) {
            val scale: Float = (mDistanceY / targetHeight).toFloat()
            val alpha: Float = scale * 255
            child.setBackgroundColor(Color.argb(alpha.toInt(), 255, 124, 2))

        } else if (mDistanceY > targetHeight) {
            child.setBackgroundColor(Color.rgb(255, 124, 2))
        }

    }



}