package com.gb.m_1919_1872_1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.view.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.container,PictureOfTheDayFragment.newInstance()).commit()
        }
    }
}