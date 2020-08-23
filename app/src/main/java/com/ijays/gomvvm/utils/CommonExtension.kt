package com.ijays.gomvvm.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat

/**
 * Some common extensions
 */
inline fun <reified T : AppCompatActivity> Activity.start(context: Context) {
    startActivity(Intent(context, T::class.java))
}

/**
 * start an activity with fade_in animation
 */
inline fun <reified T : AppCompatActivity> AppCompatActivity.startActivityWithFadeIn(context: Context) {
    val bundle = ActivityOptionsCompat.makeCustomAnimation(
        context, android.R.anim.fade_in, android.R.anim.fade_out
    ).toBundle()

    val intent = Intent(context, T::class.java)
    startActivity(intent,bundle)

}