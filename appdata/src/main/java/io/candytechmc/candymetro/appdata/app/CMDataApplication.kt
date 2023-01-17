package io.candytechmc.candymetro.appdata.app

import io.candytechmc.candymetro.arch.app.CMArchApplication
import org.koin.core.module.Module
import org.koin.dsl.module

open class CMDataApplication : CMArchApplication() {

    override fun getKoinModules(): List<Module> {
        return super.getKoinModules() + dataModule
    }

    private val dataModule = module {

    }
}