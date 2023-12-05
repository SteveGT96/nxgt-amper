package com.strange

import android.app.Application
import helpers.initKoin

class MainApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		initKoin(applicationContext)
	}
}