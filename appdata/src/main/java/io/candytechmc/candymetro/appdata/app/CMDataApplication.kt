package io.candytechmc.candymetro.appdata.app

import io.candytechmc.candymetro.appdata.db.AppDatabase
import io.candytechmc.candymetro.arch.app.CMArchApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * AppData Application
 * @author Sokeriaaa
 * @date 2023/1/17
 */
open class CMDataApplication : CMArchApplication() {

    override fun getKoinModules(): List<Module> {
        return super.getKoinModules() + dataModule
    }

    private val dataModule = module {
        // Database
        single {
            AppDatabase.provideDatabase(context = androidContext())
        }
        // Dao
        single {
            get<AppDatabase>().getLineDao()
        }
        single {
            get<AppDatabase>().getStationDao()
        }
    }
}