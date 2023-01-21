package io.candytechmc.candymetro.ui.lines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import io.candytechmc.candymetro.appdata.db.dao.LineDao
import io.candytechmc.candymetro.appdata.db.dao.StationDao
import io.candytechmc.candymetro.appdata.db.table.LineEntity
import io.candytechmc.candymetro.appdata.db.table.StationEntity
import io.candytechmc.candymetro.arch.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.inject

/**
 * Line list ViewModel
 * @author Sokeriaaa
 * @date 2023/1/17
 */
class LinesViewModel : BaseViewModel() {

    private val lineDao: LineDao by inject()
    private val stationDao: StationDao by inject()

    val lineList = mutableStateListOf<LineEntity>()

    var selectedLineID by mutableStateOf(0)

    val lineStationList = mutableStateListOf<StationEntity>()

    fun initLines() {
        viewModelScope.launch(Dispatchers.IO) {
            lineList.clear()
            lineList.addAll(lineDao.queryAll())
        }
    }

    fun queryStationsForLine(lineID: Int) {
        selectedLineID = lineID
        refreshStations()
    }

    private fun refreshStations() {
        viewModelScope.launch(Dispatchers.IO) {
            lineStationList.clear()
            lineStationList.addAll(stationDao.queryForLine(lineID = selectedLineID))
        }
    }

}