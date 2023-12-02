import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
actual fun Screen(content: @Composable () -> Unit) {
	val systemUiController = rememberSystemUiController()
	val darkTheme = isSystemInDarkTheme()
	val color = MaterialTheme.colorScheme.background

	SideEffect {
		systemUiController.setNavigationBarColor(color, darkIcons = !darkTheme)
		systemUiController.setStatusBarColor(color, darkIcons = !darkTheme)
	}

	val context = LocalContext.current

	val lightColorScheme = lightColorScheme(
		primary = Color.Green,
		secondary = Color.Cyan
	)
	val darkColorScheme = darkColorScheme(
		primary = Color.Green,
		secondary = Color.Cyan
	)

	val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
	val colors = when {
		dynamicColor && darkTheme -> dynamicDarkColorScheme(context)
		dynamicColor && !darkTheme -> dynamicLightColorScheme(context)
		darkTheme -> darkColorScheme
		else -> lightColorScheme
	}

	MaterialTheme(colorScheme = colors) {
		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			content()
		}
	}
}