package io.candytechmc.candymetro.appdata.db

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.candytechmc.candymetro.appdata.db.table.StationEntity

/**
 * Database type converter
 * @author Sokeriaaa
 * @date 2023/1/21
 */
class MyTypeConverter {

    private val defaultGson = GsonBuilder().disableHtmlEscaping().create()

    @TypeConverter
    fun interchangeListToString(list: List<StationEntity.Interchange>): String =
        defaultGson.toJson(list)

    @TypeConverter
    fun stringToInterchangeList(string: String): List<StationEntity.Interchange> =
        defaultGson.fromJson(
            string,
            object : TypeToken<List<StationEntity.Interchange>>() {}.type
        )

    @TypeConverter
    fun platformListToString(list: List<StationEntity.Platform>): String =
        defaultGson.toJson(list)

    @TypeConverter
    fun stringToPlatformList(string: String): List<StationEntity.Platform> =
        defaultGson.fromJson(
            string,
            object : TypeToken<List<StationEntity.Platform>>() {}.type
        )

}