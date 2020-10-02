package com.ijays.gomvvm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * params to open browser
 */
@Parcelize
data class BrowserLoadOptionModel(
    var link: String,
    var title: String? = null
) : Parcelable