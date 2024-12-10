package com.vijaykuppli.android.screen.bottomnav

import androidx.annotation.DrawableRes
import com.vijaykuppli.android.R

data class FeatureList(
    val title: String,
    @DrawableRes val image: Int = R.drawable.search
)