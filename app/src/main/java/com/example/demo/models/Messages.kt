package com.example.demo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Messages(
    val promotionalMessage: String?,
    val secondaryMessage: String?
) : Parcelable