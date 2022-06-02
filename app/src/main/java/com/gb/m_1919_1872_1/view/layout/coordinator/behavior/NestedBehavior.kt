package com.gb.m_1919_1872_1.view.layout.coordinator.behavior

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.gb.m_1919_1872_1.view.layout.coordinator.CoordinatorFragment
import com.google.android.material.appbar.AppBarLayout

class NestedBehavior(
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
        Log.d("","")
        if(dependency is AppBarLayout){
           val bar =  dependency as AppBarLayout
            child.y = 0+bar.height.toFloat()+bar.y
        }else{

        }
        return super.onDependentViewChanged(parent, child, dependency)
    }

}