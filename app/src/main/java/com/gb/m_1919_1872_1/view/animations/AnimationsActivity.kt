package com.gb.m_1919_1872_1.view.animations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1919_1872_1.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration: Long = 1000

    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.header.isSelected = true
        binding.header.isSelected = false*/
        binding.scrollView.setOnScrollChangeListener { _, _, _, _, _ ->
            binding.header.isSelected = binding.scrollView.canScrollVertically(-1)
        }
    }


}