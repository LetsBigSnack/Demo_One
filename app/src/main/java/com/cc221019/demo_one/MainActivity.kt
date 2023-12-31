package com.cc221019.demo_one

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cc221019.demo_one.ui.components.mainScreen
import com.cc221019.demo_one.ui.theme.Demo_OneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo_OneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainScreen(){
                            name, uid ->

                        var intent = Intent(this, MainActivity2::class.java)
                        intent.putExtra("name", name)
                        intent.putExtra("uid", uid)


                        startActivity(intent)

                    }
                }
            }
        }
    }
}
