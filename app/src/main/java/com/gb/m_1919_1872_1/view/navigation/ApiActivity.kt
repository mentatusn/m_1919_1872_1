package com.gb.m_1919_1872_1.view.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1919_1872_1.databinding.ActivityApiBinding
import com.gb.m_1919_1872_1.view.navigation.viewpager.ViewPager2Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPager2Adapter(this)


        TabLayoutMediator(binding.tabLayout,binding.viewPager,object :TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                //TDDO HW настраиваем tab
                tab.text = when(position){
                    0-> "Earth"
                    1-> "System"
                    else -> "Mars"
                }
            }
        } ).attach()

    }
}