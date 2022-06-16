package com.gb.m_1919_1872_1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.view.picture.PictureOfTheDayFragment
import com.google.android.material.color.DynamicColors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO HW 1 обязательно перед setContentView


        setTheme(R.style.MyBlueTheme)
        setContentView(R.layout.activity_main)

        // TODO HW 2 если момент setContentView уже упущен, то вызываем  recreate()
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,PictureOfTheDayFragment.newInstance()).commit()
        }
    }
}