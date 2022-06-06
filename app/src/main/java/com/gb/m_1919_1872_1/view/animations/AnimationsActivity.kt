package com.gb.m_1919_1872_1.view.animations

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.*
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.ActivityAnimationsBinding
import com.gb.m_1919_1872_1.databinding.ActivityAnimationsBonusStartBinding
import com.gb.m_1919_1872_1.databinding.ActivityAnimationsKirillBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration: Long = 1000

    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsKirillBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsKirillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val constraintSetStart = ConstraintSet()
        val constraintSetEnd = ConstraintSet()
        constraintSetStart.clone(this,R.layout.include_fab_animations_start)
        constraintSetEnd.clone(this,R.layout.include_fab_animations_end)
        binding.anim.fabCenter.setOnClickListener {



            val transitionSet = TransitionSet()
            val transitionCB = ChangeBounds()
            val transitionFade = Fade()
            transitionSet.addTransition(transitionCB)
            transitionSet.addTransition(transitionFade)
            transitionSet.interpolator = AnticipateOvershootInterpolator(5f)
            transitionSet.duration = 1000
            TransitionManager.beginDelayedTransition(binding.anim.container,transitionSet )

            isOpen = !isOpen
            if(!isOpen){
                constraintSetStart.applyTo(binding.anim.container)
            }else{
                constraintSetEnd.applyTo(binding.anim.container)
            }

        }
    }


}