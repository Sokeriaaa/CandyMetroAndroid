package io.candytechmc.candymetro.arch.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

open class CMArchApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        // Multidex
        MultiDex.install(this)
        // MMKV
        MMKV.initialize(this)
        // Koin
        startKoin {
            androidLogger()
            androidContext(androidContext = this@CMArchApplication)
            modules(modules = getKoinModules())
        }
    }

    open fun getKoinModules(): List<Module> {
        return listOf(archModule)
    }

    private val archModule = module {

    }

}