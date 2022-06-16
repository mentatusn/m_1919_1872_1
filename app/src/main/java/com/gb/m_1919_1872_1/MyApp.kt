package com.gb.m_1919_1872_1

import android.app.Application
import com.google.android.material.color.DynamicColors

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}