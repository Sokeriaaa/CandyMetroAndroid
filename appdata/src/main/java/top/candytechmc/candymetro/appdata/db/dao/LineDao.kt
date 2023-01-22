package top.candytechmc.candymetro.appdata.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import top.candytechmc.candymetro.appdata.db.table.LineEntity

/**
 * Metro lines Dao
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@Dao
interface LineDao {

    @Query(
        value = "SELECT * FROM `${LineEntity.tableName}`"
    )
    fun queryAll(): List<LineEntity>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun insertList(list: List<LineEntity>)

    @Query(
        value = "DELETE FROM `${LineEntity.tableName}`"
    )
    fun clear()

}