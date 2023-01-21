package io.candytechmc.candymetro.ui.lines

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import io.candytechmc.candymetro.R
import io.candytechmc.candymetro.ui.common.SingleFilterChipGroup

/**
 * Line list scene
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LinesScene(
    rootNavHostController: NavHostController,
    viewModel: LinesViewModel = viewModel()
) {
    LaunchedEffect(true) {
        viewModel.initLines()
        viewModel.queryStationsForLine(1)
    }
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        stickyHeader {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier.padding(all = 4.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = stringResource(id = R.string.line_list_select_line),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleLarge
                    )
                    SingleFilterChipGroup(
                        modifier = Modifier.fillMaxWidth(),
                        initIndex = 0,
                        chipList = viewModel.lineList.map {
                            stringResource(id = R.string.line_label, it.lineID) +
                                    if (it.isOpen) {
                                        ""
                                    } else {
                                        " (${stringResource(id = R.string.opening_soon)})"
                                    }
                        }.toTypedArray(),
                        onChipClicked = {
                            viewModel.queryStationsForLine(viewModel.lineList[it].lineID)
                        }
                    )
                }
            }
        }
        items(
            items = viewModel.lineStationList
        ) {
            LinesStationCard(
                modifier = Modifier.padding(horizontal = 8.dp),
                station = it
            )
        }
    }
}