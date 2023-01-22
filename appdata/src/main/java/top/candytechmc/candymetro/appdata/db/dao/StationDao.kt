package top.candytechmc.candymetro.appdata.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import top.candytechmc.candymetro.appdata.db.table.StationEntity

/**
 * Metro station Dao
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@Dao
interface StationDao {

    @Query(
        value = "SELECT * FROM `${StationEntity.tableName}`"
    )
    fun queryAll(): List<StationEntity>

    @Query(
        value = "SELECT * FROM `${StationEntity.tableName}` WHERE `line_id` == :lineID " +
                "ORDER BY `station_id` ASC"
    )
    fun queryForLine(lineID: Int): List<StationEntity>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun insertList(list: List<StationEntity>)

    @Query(
        value = "DELETE FROM `${StationEntity.tableName}`"
    )
    fun clear()
}