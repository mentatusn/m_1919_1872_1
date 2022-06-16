package com.gb.m_1919_1872_1.view.ux

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.view.MainActivity
import com.gb.m_1919_1872_1.view.picture.PictureOfTheDayFragment
import com.google.android.material.color.DynamicColors

@SuppressLint("CustomSplashScreen") // Android 12
class SplashActivity : AppCompatActivity() { //TODO HW single-activity пытаемся сохранить
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setTheme(R.style.MyBlueTheme)
        setContentView(R.layout.activity_splash)

        /*ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.imageView), View.ROTATION, 720f)
            .setDuration(4000).start()*/
        findViewById<ImageView>(R.id.imageView).animate().rotationBy(720f).setDuration(4000).start()
        /*Handler(mainLooper).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 3000)*/

    }
}