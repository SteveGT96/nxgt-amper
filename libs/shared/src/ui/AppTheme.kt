package ui

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.strange.shared.R
import helpers.*

@Composable
fun AppTheme(
  useDarkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable() () -> Unit
) {

    val systemUiController = rememberSystemUiController()

    val context = LocalContext.current

    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    val colorScheme = when {
        dynamicColor && useDarkTheme -> dynamicDarkColorScheme(context)
        dynamicColor && !useDarkTheme -> dynamicLightColorScheme(context)
        else -> colors
    }

    SideEffect {
        systemUiController.setNavigationBarColor(colorScheme.background, darkIcons = !useDarkTheme)
        systemUiController.setStatusBarColor(colorScheme.background, darkIcons = !useDarkTheme)
    }

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}