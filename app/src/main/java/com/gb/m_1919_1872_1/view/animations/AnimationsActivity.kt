package com.gb.m_1919_1872_1.view.animations

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.ActivityAnimationsBinding
import com.gb.m_1919_1872_1.databinding.ActivityAnimationsBonusStartBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration: Long = 1000

    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsBonusStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backgroundImage.setOnClickListener {

            val constraintSet = ConstraintSet()
            //constraintSet.clone(binding.constraintContainer)

            val transition = ChangeBounds()
            transition.interpolator = AnticipateOvershootInterpolator(5f)
            transition.duration = 1000
            TransitionManager.beginDelayedTransition(binding.constraintContainer,transition )

            isOpen = !isOpen
            if(isOpen){
                constraintSet.clone(this, R.layout.activity_animations_bonus_end)
            }else{
                constraintSet.clone(this, R.layout.activity_animations_bonus_start)
            }


            constraintSet.applyTo(binding.constraintContainer)
        }
    }


}