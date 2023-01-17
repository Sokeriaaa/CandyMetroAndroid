package io.candytechmc.candymetro.appdata.db.table

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = StationEntity.tableName,
    primaryKeys = ["line_id", "station_id"]
)
class StationEntity(
    @ColumnInfo(name = "line_id")
    val lineID: Int,
    @ColumnInfo(name = "station_id")
    val stationID: Int,
) {

    @ColorInt
    @ColumnInfo(name = "color")
    var color: Int = 0

    @ColumnInfo(name = "zhs_name")
    var zhsName: String = ""

    @ColumnInfo(name = "zht_name")
    var zhtName: String = ""

    @ColumnInfo(name = "en_name")
    var enName: String = ""

    @ColumnInfo(name = "x")
    var x: Int = 0

    @ColumnInfo(name = "y")
    var y: Int = 0

    @ColumnInfo(name = "platforms_raw")
    var platformsRaw: String = ""

    @ColumnInfo(name = "transfer_raw")
    var transferRaw: String = ""

    @ColumnInfo(name = "length")
    var length: Int = 0

    @ColumnInfo(name = "is_open")
    var isOpen: Boolean = false

    companion object {
        const val tableName = "cm_station"
    }

}