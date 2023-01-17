package io.candytechmc.candymetro.app

import io.candytechmc.candymetro.appdata.app.CMDataApplication
import org.koin.core.module.Module
import org.koin.dsl.module

class CMApplication : CMDataApplication() {

    override fun getKoinModules(): List<Module> {
        return super.getKoinModules() + appModule
    }

    private val appModule = module {

    }

}