package com.strange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import api.type.CreateUserInput
import ui.AppTheme
import com.strange.shared.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(this) {
                Scaffold {
                    Column(Modifier.padding(it)) {
                        ElevatedButton(onClick = {}) {
                            Text("Click Me")
                        }
                        Text(stringResource(R.string.hello_world, CreateUserInput("SteveGt96", "ss", "ss").username))
                    }
                }
            }
        }
    }
}