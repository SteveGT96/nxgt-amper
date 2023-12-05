package helpers

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import sharedModule

fun initKoin(context: Context, vararg modules: Module) {
	startKoin {
		androidLogger()
		androidContext(context)
		modules(sharedModule(context).plus(modules.toList()))
	}
}