package configs

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import services.SizeClassService

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun initSizeClassConfig(activity: Activity) {
	val windowSizeClass = calculateWindowSizeClass(activity)
	koinInject<SizeClassService>().apply { initSizeClass(windowSizeClass) }
}