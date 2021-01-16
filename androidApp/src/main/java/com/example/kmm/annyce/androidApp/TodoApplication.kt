package com.example.kmm.annyce.androidApp

import android.app.Application
import co.touchlab.kermit.Kermit
import com.example.kmm.annyce.androidApp.di.appModule
import com.example.kmm.annyce.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.inject

class TodoApplication : Application(), KoinComponent {

    private val logger: Kermit by inject()

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@TodoApplication)
            modules(appModule)
        }

        logger.d { "TodoApplication created" }
    }
}
