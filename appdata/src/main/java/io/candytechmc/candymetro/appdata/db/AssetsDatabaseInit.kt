package io.candytechmc.candymetro.appdata.db

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.candytechmc.candymetro.appdata.db.dao.LineDao
import io.candytechmc.candymetro.appdata.db.dao.StationDao
import io.candytechmc.candymetro.appdata.db.table.LineEntity
import io.candytechmc.candymetro.appdata.db.table.StationEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Initialize assets json
 * @author Sokeriaaa
 * @date 2023/1/19
 */
object AssetsDatabaseInit : KoinComponent {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val lineDao: LineDao by inject()
    private val stationDao: StationDao by inject()

    /**
     * Import data from json in assets
     */
    fun initLinesAndStations(context: Context) {
        coroutineScope.launch {
            val defaultGson = GsonBuilder().disableHtmlEscaping().create()

            val linesJson = context.assets.open("lines.json")
                .bufferedReader().use { it.readText() }
            val stationJson = context.assets.open("stations.json")
                .bufferedReader().use { it.readText() }

            val linesList: List<LineEntity> = defaultGson.fromJson(
                linesJson,
                object : TypeToken<List<LineEntity>>() {}.type
            )
            val stationList: List<StationEntity> = defaultGson.fromJson(
                stationJson,
                object : TypeToken<List<StationEntity>>() {}.type
            )

            lineDao.clear()
            stationDao.clear()
            lineDao.insertList(linesList)
            stationDao.insertList(stationList)
        }
    }

}