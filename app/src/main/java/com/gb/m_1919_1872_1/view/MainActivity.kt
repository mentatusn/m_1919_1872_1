package com.gb.m_1919_1872_1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.view.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO HW 1 обязательно перед setContentView
        setTheme(R.style.MyGreenTheme)
        setContentView(R.layout.activity_main)
        // TODO HW 2 если момент setContentView уже упущен, то вызываем  recreate()
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,PictureOfTheDayFragment.newInstance()).commit()
        }
    }
}