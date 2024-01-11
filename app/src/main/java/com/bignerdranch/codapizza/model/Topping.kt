package com.bignerdranch.codapizza.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.bignerdranch.codapizza.R

enum class Topping(
    @StringRes val toppingName: Int,
    @DrawableRes val pizzaOverLayImage: Int
) {
    Basil(
        toppingName = R.string.topping_basil,
        pizzaOverLayImage = R.drawable.topping_basil
    ),
    Mushroom(
        toppingName = R.string.topping_mushroom,
        pizzaOverLayImage = R.drawable.topping_mushroom
    ),
    Olive(
        toppingName = R.string.topping_olive,
        pizzaOverLayImage = R.drawable.topping_olive
    ),
    Peppers(
        toppingName = R.string.topping_peppers,
        pizzaOverLayImage = R.drawable.topping_peppers
    ),
    Pepperoni(
        toppingName = R.string.topping_pepperoni,
        pizzaOverLayImage = R.drawable.topping_pepperoni
    ),
    Pineapple(
        toppingName = R.string.topping_pineapple,
        pizzaOverLayImage = R.drawable.topping_pineapple
    )
}