package io.candytechmc.candymetro.appdata.db.table

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Metro station table
 * @author Sokeriaaa
 * @date 2023/1/17
 */
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

    @ColumnInfo(name = "jp_name")
    var jpName: String = ""

    @ColumnInfo(name = "kr_name")
    var krName: String = ""

    @ColumnInfo(name = "x")
    var x: Int = 0

    @ColumnInfo(name = "y")
    var y: Int = 0

    @ColumnInfo(name = "platforms_raw")
    var platformList: List<Platform> = emptyList()

    @ColumnInfo(name = "transfer_raw")
    var interchangeList: List<Interchange> = emptyList()

    @ColumnInfo(name = "length")
    var length: Int = 0

    @ColumnInfo(name = "is_open")
    var isOpen: Boolean = false

    data class Platform(
        val platformID: Int,
        val isLeft: Boolean
    )

    data class Interchange(
        val lineID: Int,
        val stationID: Int,
        @ColorInt
        val color: Int,
        val isOpen: Boolean
    )

    companion object {
        const val tableName = "cm_station"
    }

}