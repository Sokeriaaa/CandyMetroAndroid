package top.candytechmc.candymetro.ui.lines

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.candytechmc.candymetro.R
import top.candytechmc.candymetro.appdata.db.table.StationEntity
import top.candytechmc.candymetro.ui.common.metro.LineNumIcon
import top.candytechmc.candymetro.ui.common.metro.StationNumIcon

/**
 * Station card in line list
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@Composable
fun LinesStationCard(
    modifier: Modifier = Modifier,
    station: StationEntity,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .alpha(
                    if (station.isOpen) {
                        1F
                    } else {
                        0.4F
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            StationNumIcon(
                modifier = Modifier.requiredSize(48.dp),
                lineID = station.lineID,
                stationID = station.stationID,
                lineColorInt = station.color
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = when (
                            stringResource(id = R.string.data_resource_lang_type)
                        ) {
                            "0" -> station.zhsName
                            "1" -> station.zhtName
                            else -> station.zhsName
                        },
                        style = MaterialTheme.typography.titleLarge
                    )
                    if (!station.isOpen) {
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "(${stringResource(id = R.string.opening_soon)})",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Text(
                    text = station.enName,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            StationInterchangePart(
                openedInterchangeList = station.interchangeList.filter { it.isOpen }
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun StationInterchangePart(
    openedInterchangeList: List<StationEntity.Interchange>
) {
    if (openedInterchangeList.isEmpty()) {
        return
    }
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Text(
            modifier = Modifier.padding(bottom = 3.dp),
            text = stringResource(id = R.string.interchange),
            style = MaterialTheme.typography.bodySmall
        )
        Row {
            openedInterchangeList.forEach {
                LineNumIcon(
                    modifier = Modifier
                        .size(28.dp)
                        .padding(start = 4.dp),
                    lineID = it.lineID,
                    lineColorInt = it.color
                )
            }
        }
    }
}

@Preview
@Composable
fun Test() {
    LinesStationCard(
        modifier = Modifier.padding(horizontal = 8.dp),
        station = StationEntity(
            lineID = 1,
            stationID = 13
        ).also {
            it.zhsName = "青石坞"
            it.enName = "Qingshiwu"
            it.color = 0xFF99FF
            it.interchangeList = listOf(
                StationEntity.Interchange(
                    lineID = 2,
                    stationID = 9,
                    color = 0x99FFFF,
                    isOpen = true
                )
            )
        }
    )
}