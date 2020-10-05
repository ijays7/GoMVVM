package com.ijays.core.base.activity

import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

// Easy to switch base activity in future
typealias BaseActivity = DaggerActivity


@AndroidEntryPoint
abstract class DaggerActivity : AppCompatActivity()