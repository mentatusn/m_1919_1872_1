package com.gb.m_1919_1872_1.view.layout.coordinator.behavior

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

class ButtonBehavior(
    context: Context,
    attrs: AttributeSet? = null
) : CoordinatorLayout.Behavior<View>(context, attrs) {


    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return (dependency is AppBarLayout)
    }


    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        Log.d("", "")

        val bar = dependency as AppBarLayout
        child.alpha = 1 - abs(2 * bar.y) / bar.height.toFloat()
        child.x =
            (bar.width.toFloat() - child.width.toFloat()) * (1 - abs(2 * bar.y) / bar.height.toFloat())

        return super.onDependentViewChanged(parent, child, dependency)
    }

}