package services

import androidx.compose.material3.windowsizeclass.WindowSizeClass

class SizeClassService {
	lateinit var size: WindowSizeClass

	fun initSizeClass(value: WindowSizeClass) {
		size = value
	}
}