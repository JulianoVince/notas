package com.example.notas

import android.app.Application
import com.example.notas.di.ModulosDependencias
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(ModulosDependencias.moduloDaApp))
        }
    }

}