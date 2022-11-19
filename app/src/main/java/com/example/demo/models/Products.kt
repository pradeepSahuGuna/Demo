package com.example.demo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Products(
     val products: List<Product>
): Parcelable