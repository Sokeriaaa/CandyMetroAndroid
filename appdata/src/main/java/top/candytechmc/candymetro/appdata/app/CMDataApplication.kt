package top.candytechmc.candymetro.appdata.app

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import top.candytechmc.candymetro.appdata.db.AppDatabase
import top.candytechmc.candymetro.appdata.db.AssetsDatabaseInit
import top.candytechmc.candymetro.arch.app.CMArchApplication

/**
 * AppData Application
 * @author Sokeriaaa
 * @date 2023/1/17
 */
open class CMDataApplication : CMArchApplication() {

    override fun onCreate() {
        super.onCreate()
        AssetsDatabaseInit.initLinesAndStations(this)
    }

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