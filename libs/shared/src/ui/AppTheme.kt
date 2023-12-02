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

    val color = MaterialTheme.colorScheme.background

    SideEffect {
        systemUiController.setNavigationBarColor(color, darkIcons = !useDarkTheme)
        systemUiController.setStatusBarColor(color, darkIcons = !useDarkTheme)
    }

    val context = LocalContext.current

    val lightColorScheme = lightColorScheme(
        primary = colorResource(R.color.purple_500),
        secondary = colorResource(R.color.purple_200)
    )
    val darkColorScheme = darkColorScheme(
        primary = colorResource(R.color.purple_500),
        secondary = colorResource(R.color.purple_200)
    )

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

  MaterialTheme(
    colorScheme = colorScheme,
    content = content
  )
}