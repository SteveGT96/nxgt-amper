package ui

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import helpers.*

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AppTheme(
	activity: Activity, useDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit
) {

	val systemUiController = rememberSystemUiController()

	val context = LocalContext.current

	val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

	val colors = if(!useDarkTheme) {
		LightColors
	} else {
		DarkColors
	}

	val colorScheme = when {
		dynamicColor && useDarkTheme -> dynamicDarkColorScheme(context)
		dynamicColor && !useDarkTheme -> dynamicLightColorScheme(context)
		else -> colors
	}

	val windowSizeClass = calculateWindowSizeClass(activity)

	SideEffect {
		systemUiController.setNavigationBarColor(colorScheme.background, darkIcons = !useDarkTheme)
		systemUiController.setStatusBarColor(colorScheme.background, darkIcons = !useDarkTheme)
	}

	MaterialTheme(
		colorScheme = colorScheme
	) {
		CompositionLocalProvider(LocalWindowSize provides windowSizeClass, content = content)
	}
}