package com.bignerdranch.codapizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.bignerdranch.codapizza.model.Topping
import com.bignerdranch.codapizza.model.ToppingPlacement
import com.bignerdranch.codapizza.ui.PizzaBuilderScreen
import com.bignerdranch.codapizza.ui.ToppingCell

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Compose doesn't need this
//        setContentView(R.layout.activity_main)
        setContent {
//            Text(text = "Helo World!")
           PizzaBuilderScreen()
        }
    }

//    @Composable
//    private fun ToppingCell() {
//        Row {
//            Checkbox(checked = true, onCheckedChange = { /*TODO*/ })
//            Column {
//                Text(text = "Pineapple")
//                Text(text = "Whole Pizza")
//            }
//        }
//    }
}