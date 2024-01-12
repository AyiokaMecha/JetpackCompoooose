package com.bignerdranch.codapizza


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.ComposeView
import androidx.core.app.ComponentActivity
import com.bignerdranch.codapizza.ui.AppTheme
import com.bignerdranch.codapizza.ui.PizzaBuilderScreen

@SuppressLint("RestrictedApi")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Compose doesn't need this
//        setContentView(R.layout.activity_main)
        setContentView(ComposeView(this).apply {
            setContent {
//            Text(text = "Hello World!")
                AppTheme {
                    PizzaBuilderScreen()
                }
        }

        })
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