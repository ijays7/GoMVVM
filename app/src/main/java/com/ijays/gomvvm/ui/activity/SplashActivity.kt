package com.ijays.gomvvm.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.ijays.gomvvm.databinding.ActivitySplashLayoutBinding
import com.ijays.gomvvm.utils.startActivityWithFadeIn

/**
 * Splash page
 * Created by ijays on 2020/6/18.
 */
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                startActivityWithFadeIn<MainActivity>(this@SplashActivity)
                finish()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        binding.motionLayout.startLayoutAnimation()
    }
}