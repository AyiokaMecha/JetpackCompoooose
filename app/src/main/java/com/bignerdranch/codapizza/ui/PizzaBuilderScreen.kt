package com.bignerdranch.codapizza.ui

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.bignerdranch.codapizza.R
import com.bignerdranch.codapizza.model.Topping
import com.bignerdranch.codapizza.model.ToppingPlacement
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.bignerdranch.codapizza.model.Pizza
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import java.text.NumberFormat

//private var pizza = Pizza(
//    toppings = mapOf(
//        Topping.Pepperoni to ToppingPlacement.All,
//        Topping.Pineapple to ToppingPlacement.All
//    )
//)
//    set(value) {
//        Log.d("PizzaBuilderScreen", "Reassigned pizza to $value")
//    }

//private var pizza by mutableStateOf(Pizza())

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun PizzaBuilderScreen(
    modifier: Modifier = Modifier
) {
    var pizza by rememberSaveable {
        mutableStateOf(Pizza())
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar (
                title = { Text(stringResource(id = R.string.app_name))}
            )
        },
        content = {
            Column(
                modifier = modifier
            ) {

                ToppingListing(
                    pizza = pizza,
                    onEditPizza = { pizza = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = true)
                )
                OrderButton(
                    pizza = pizza,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    )

}

@Composable
private fun ToppingListing(
    pizza: Pizza,
    onEditPizza: (Pizza) -> Unit,
    modifier: Modifier = Modifier
) {
//    var showToppingPlacementDialog by rememberSaveable {
//        mutableStateOf(false)
//    }
//    if (showToppingPlacementDialog) {
//        ToppingPlacementDialog (
//            onDismissRequest = {
//                showToppingPlacementDialog = false
//            }
//        )
//    }
    var toppingBeingAdded by rememberSaveable {
        mutableStateOf<Topping?>(null)
    }
    toppingBeingAdded?.let { topping: Topping ->
        ToppingPlacementDialog(topping = topping,
            onSetToppingPlacement = {placement ->
            onEditPizza(pizza.withTopping(topping, placement = placement))
            },
            onDismissRequest = {
                toppingBeingAdded = null
            })
    }
    LazyColumn(modifier = modifier) {
        item {
            PizzaHeroImage(pizza = pizza,
                modifier = Modifier.padding(16.dp) )
        }
        items(Topping.values()) {topping ->
            ToppingCell(topping = topping, placement = pizza.toppings[topping], onClickTopping = {
//                val isOnPizza = pizza.toppings[topping] != null
//                onEditPizza( pizza.withTopping(topping = topping, placement = if(isOnPizza) {
//                    null
//                } else {
//                    ToppingPlacement.All
//                }))
//            }
//                    )
//        showToppingPlacementDialog = true
                toppingBeingAdded = topping
            })
    }
//    ToppingCell(topping = Topping.Pepperoni, placement = ToppingPlacement.Left, onClickTopping = {}, modifier = modifier )

}}

@Composable
private fun OrderButton(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Button(
        onClick = {
                  Toast.makeText(context, R.string.order_placed_toast, Toast.LENGTH_SHORT).show()
        },
        modifier = modifier) {
        val currencyFormatter = remember { NumberFormat.getCurrencyInstance() }
        val price = currencyFormatter.format(pizza.price)
        Text(text = stringResource(id = R.string.place_order_button, price).toUpperCase(Locale.current))
    }
}

