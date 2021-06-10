package io.korostenskyi.launchitandroid

import android.app.Application
import io.korostenskyi.shared.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        initKoin {
            androidContext(this@App)
        }
    }
}
