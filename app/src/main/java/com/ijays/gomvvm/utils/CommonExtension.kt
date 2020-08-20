package com.ijays.gomvvm.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * Some common extensions
 */
inline fun <reified T : AppCompatActivity> Activity.start(context: Context) {
    startActivity(Intent(context, T::class.java))
}