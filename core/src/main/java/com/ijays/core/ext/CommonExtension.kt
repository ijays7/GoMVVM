package com.ijays.core.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity

/**
 * Convenient for dp to px
 */
val Number.dp: Int get() = (toInt() * Resources.getSystem().displayMetrics.density).toInt()

/**
 * Convenient for sp to px
 */
val Number.sp: Int get() = (toInt() * Resources.getSystem().displayMetrics.scaledDensity).toInt()

/**
 * Quickly start an Activity
 */
inline fun <reified T : AppCompatActivity> Activity.start(context: Context) {
    startActivity(Intent(this, T::class.java))
}

fun Any?.isNull() = this == null

fun Any?.isNotNull() = this != null

/**
 * Used for not null
 */
inline fun <T, R> T?.runIfNotNull(block: T.() -> R): R? = this?.block()