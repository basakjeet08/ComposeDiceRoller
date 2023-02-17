package com.anirban.composediceroller

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.anirban.composediceroller.ui.theme.ComposeDiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

// This Function draws the Image and the Button in the Center of the App
@Composable
fun DrawUI(){

    // This array contains all the Images Drawable Resource id in Int
    val diceImages = arrayListOf(
        R.drawable.dice_1 ,
        R.drawable.dice_2 ,
        R.drawable.dice_3 ,
        R.drawable.dice_4 ,
        R.drawable.dice_5 ,
        R.drawable.dice_6 ,
        )

    // This value is a state variable which remembers its state and the composable function is
    // called again when the state of these variable changes
    var currentImage by remember { mutableStateOf(diceImages[0]) }

    // The Column lets the user to draw UI vertically
    Column (
        modifier = Modifier.fillMaxSize() ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        Image(
            painter = painterResource(id = currentImage) ,
            contentDescription = null
        )

        /*
        The Button lets the User to draw a Button which accepts a onclick and updates the
        currentImage randomly by the help of random variable
         */
        Button(

            // This Block is executed when the Button is Clicked
            onClick = {
                val result = (1..6).random()
                currentImage = diceImages[result - 1]
            }
        ) {
            Text(text = "ROLL")
        }
    }
}


// This is a Preview Function which helps us to Preview the App which developing
@Preview(
    showBackground = true ,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun MyApp(){
    ComposeDiceRollerTheme {
        Surface(
            modifier = Modifier.fillMaxSize() ,
            color = MaterialTheme.colors.background
        ){
            DrawUI()
        }
    }
}