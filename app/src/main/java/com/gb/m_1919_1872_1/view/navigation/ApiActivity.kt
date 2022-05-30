package com.gb.m_1919_1872_1.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.ActivityApiBinding
import com.gb.m_1919_1872_1.view.navigation.viewpager.ViewPagerAdapter

class ApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_earth)
        binding.tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_system)
        binding.tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_mars)
        //binding.textOne.setTextColor(resources.getColor(R.color.red))
       // binding.textOne.setTextColor(resources.getColor(R.color.blu))
    }
}