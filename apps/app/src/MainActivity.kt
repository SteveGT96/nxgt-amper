package com.strange

import World
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import api.type.CreateUserInput
import configs.initSizeClassConfig
import ui.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            initSizeClassConfig(this)
            AppTheme {
                Scaffold {
                    Column(Modifier.padding(it)) {
                        ElevatedButton(onClick = {}) {
                            Text("Click Me")
                        }
                        Text("Hello, ${CreateUserInput("SteveGt96", "ss", "ss").username}!")
                    }
                }
            }
        }
    }
}