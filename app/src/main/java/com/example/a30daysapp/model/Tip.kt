package com.example.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val heading: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)
