package helpers

import androidx.compose.material3.windowsizeclass.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Dp.sm
	get() = this >= 640.dp

val Dp.md
	get() = this  >= 768.dp

val Dp.lg
	get() = this >= 1024.dp

val Dp.xl
	get() = this >= 1280.dp

val WindowSizeClass.wCompact: Boolean
	get() = this.widthSizeClass == WindowWidthSizeClass.Compact

val WindowSizeClass.hCompact: Boolean
	get() = this.heightSizeClass == WindowHeightSizeClass.Compact

val WindowSizeClass.wMedium: Boolean
	get() = this.widthSizeClass == WindowWidthSizeClass.Medium

val WindowSizeClass.hMedium: Boolean
	get() = this.heightSizeClass == WindowHeightSizeClass.Medium

val WindowSizeClass.wExpanded: Boolean
	get() = this.widthSizeClass == WindowWidthSizeClass.Expanded

val WindowSizeClass.hExpanded: Boolean
	get() = this.heightSizeClass == WindowHeightSizeClass.Expanded