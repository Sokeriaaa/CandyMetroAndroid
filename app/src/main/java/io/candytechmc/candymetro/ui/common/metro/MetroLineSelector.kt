package io.candytechmc.candymetro.ui.common.metro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.candytechmc.candymetro.R
import io.candytechmc.candymetro.appdata.db.table.LineEntity
import io.candytechmc.candymetro.arch.utils.ColorUtils

/**
 * File description here
 * @author Sokeriaaa
 * @date 2023/1/21
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MetroLineSelector(
    modifier: Modifier = Modifier,
    initIndex: Int,
    lineList: List<LineEntity>,
    onChipClicked: (index: Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(initIndex) }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(
            items = lineList
        ) { index, item ->
            val color = Color(item.color + 0xFF000000)
            val labelColor = Color(
                ColorUtils.getForegroundColorFrom(item.color) + 0xFF000000
            )
            FilterChip(
                modifier = if (index > 0) {
                    Modifier.padding(start = 4.dp)
                } else {
                    Modifier
                },
                selected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                    onChipClicked(index)
                },
                label = {
                    Text(
                        text = stringResource(
                            id = R.string.line_label, item.lineID
                        ) + if (item.isOpen) {
                            ""
                        } else {
                            " (${stringResource(id = R.string.opening_soon)})"
                        }
                    )
                },
                leadingIcon = if (index == selectedIndex) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Localized Description",
                            modifier = Modifier.size(FilterChipDefaults.IconSize),
                            tint = labelColor
                        )
                    }
                } else {
                    null
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = color,
                    selectedLabelColor = labelColor
                )
            )
        }
    }
}