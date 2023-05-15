package com.example.projectuts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

class Pixel(
    var imagePixel: Int,
    var namePixel: String,
    var descPixel: String

    ) : Parcelable