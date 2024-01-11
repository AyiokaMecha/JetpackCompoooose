package com.bignerdranch.codapizza.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bignerdranch.codapizza.R
import com.bignerdranch.codapizza.model.Pizza
import com.bignerdranch.codapizza.model.Topping
import com.bignerdranch.codapizza.model.ToppingPlacement

@Preview
@Composable
private fun PizzaHeroImagePreview() {
    PizzaHeroImage(
        pizza = Pizza(
            toppings = mapOf(
                Topping.Pineapple to ToppingPlacement.All,
                Topping.Pepperoni to ToppingPlacement.Left,
                Topping.Basil to ToppingPlacement.Right
            )
        )
    )
}


@Composable
fun PizzaHeroImage(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier
        .aspectRatio(1f)) {
        Image(painter = painterResource(id = R.drawable.pizza_crust),
            contentDescription = stringResource(id = R.string.pizza_preview),
            modifier = Modifier.fillMaxWidth())
//            modifier = modifier)

    pizza.toppings.forEach { (topping, placement) ->
        Image(
            painter = painterResource(id = topping.pizzaOverLayImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = when(placement) {
                                        ToppingPlacement.Left -> Alignment.TopStart
                    ToppingPlacement.Right -> Alignment.TopEnd
                ToppingPlacement.All -> Alignment.Center
                                        },
            modifier = Modifier.focusable(false)
                .aspectRatio(
                    when (placement) {
                        ToppingPlacement.Left, ToppingPlacement.Right -> 0.5f
                        ToppingPlacement.All -> 1.0f
                    }
                )
                .align(when (placement) {
                    ToppingPlacement.Left -> Alignment.CenterStart
                    ToppingPlacement.Right -> Alignment.CenterEnd
                    ToppingPlacement.All -> Alignment.Center
                })
        )
    }
    }
}