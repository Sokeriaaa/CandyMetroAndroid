package io.candytechmc.candymetro.appdata.db.table

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = LineEntity.tableName,
    primaryKeys = ["line_id"]
)
class LineEntity(
    @ColumnInfo(name = "line_id")
    val lineID: Int
) {

    @ColumnInfo(name = "zhs_name")
    var zhsName: String = ""

    @ColumnInfo(name = "zht_name")
    var zhtName: String = ""

    @ColumnInfo(name = "en_name")
    var enName: String = ""

    @ColorInt
    @ColumnInfo(name = "color")
    var color: Int = 0

    companion object {
        const val tableName = "cm_line"
    }
}