package com.bignerdranch.codapizza.model

import androidx.annotation.StringRes
import com.bignerdranch.codapizza.R

enum class ToppingPlacement(
    @StringRes val label: Int
) {
    Left(label = R.string.placement_left),
    Right(label = R.string.placement_right),
    All(label = R.string.placement_all)
}