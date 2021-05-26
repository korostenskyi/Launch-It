package io.korostenskyi.launchitandroid

import android.app.Application
import io.korostenskyi.launchitandroid.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(viewModelModule)
        }
    }
}
