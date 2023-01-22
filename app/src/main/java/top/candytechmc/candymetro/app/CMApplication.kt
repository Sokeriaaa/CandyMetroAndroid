package top.candytechmc.candymetro.app

import org.koin.core.module.Module
import org.koin.dsl.module
import top.candytechmc.candymetro.appdata.app.CMDataApplication

/**
 * App layer application
 * @author Sokeriaaa
 * @date 2023/1/17
 */
class CMApplication : CMDataApplication() {

    override fun getKoinModules(): List<Module> {
        return super.getKoinModules() + appModule
    }

    private val appModule = module {

    }

}