package com.dinesh.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.dinesh.android.animation.line.MyLayoutView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    com.dinesh.android.basic.text_field.MyLayoutView()
                    MyLayoutView()
                }
            }
        }

//        startActivity(Intent(this, com.dinesh.android.home.HomeActivity::class.java))
    }
}
