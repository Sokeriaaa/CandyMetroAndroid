package io.candytechmc.candymetro.ui.lines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import io.candytechmc.candymetro.appdata.db.dao.LineDao
import io.candytechmc.candymetro.appdata.db.dao.StationDao
import io.candytechmc.candymetro.appdata.db.table.LineEntity
import io.candytechmc.candymetro.appdata.db.table.StationEntity
import io.candytechmc.candymetro.arch.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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

    var lineList by mutableStateOf(emptyList<LineEntity>())

    var selectedLineID by mutableStateOf(0)

    var lineStationList by mutableStateOf(emptyList<StationEntity>())

    private var queryStationJob: Job? = null

    fun initLines() {
        viewModelScope.launch(Dispatchers.IO) {
            lineList = lineDao.queryAll()
        }
    }

    fun queryStationsForLine(lineID: Int) {
        selectedLineID = lineID
        refreshStations()
    }

    private fun refreshStations() {
        queryStationJob?.cancel()
        queryStationJob = viewModelScope.launch(Dispatchers.IO) {
            lineStationList = stationDao.queryForLine(lineID = selectedLineID)
            queryStationJob = null
        }
    }

}