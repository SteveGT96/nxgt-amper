package helpers

import net.pearx.kasechange.toSnakeCase
import kotlin.reflect.KProperty

val KProperty<*>.snakeName: String
	get() = name.toSnakeCase()