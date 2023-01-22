package top.candytechmc.candymetro.ui.common

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
import androidx.compose.ui.unit.dp

/**
 * File description here
 * @author Sokeriaaa
 * @date 2023/1/20
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleFilterChipGroup(
    modifier: Modifier = Modifier,
    initIndex: Int,
    chipList: Array<String>,
    onChipClicked: (index: Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(initIndex) }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(
            items = chipList
        ) { index, item ->
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
                    Text(text = item)
                },
                leadingIcon = if (index == selectedIndex) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Localized Description",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                }
            )
        }
    }
}