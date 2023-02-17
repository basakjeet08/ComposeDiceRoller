package com.anirban.composediceroller

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anirban.composediceroller.ui.theme.ComposeDiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DrawUI()
                }
            }
        }
    }
}

@Composable
fun DrawUI(){

}

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