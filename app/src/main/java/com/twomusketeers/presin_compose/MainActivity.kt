package com.twomusketeers.presin_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.twomusketeers.presin_compose.navigation.Navigation
import com.twomusketeers.presin_compose.ui.theme.PresINComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresINComposeTheme {
                Surface {
                    Navigation()
                }
            }
        }
    }
}