package com.example.coroutines_koin

import android.app.Application
import com.example.coroutines_koin.di.Di
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App) //в случае если нужно перндать контекст
            modules(Di.mainModule)
        }
    }
}