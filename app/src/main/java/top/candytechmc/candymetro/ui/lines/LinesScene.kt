package top.candytechmc.candymetro.ui.lines

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import top.candytechmc.candymetro.R
import top.candytechmc.candymetro.ui.common.metro.MetroLineSelector

/**
 * Line list scene
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@Composable
fun LinesScene(
    rootNavHostController: NavHostController,
    viewModel: LinesViewModel = viewModel()
) {
    LaunchedEffect(true) {
        viewModel.initLines()
        viewModel.queryStationsForLine(1)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LineListHeader(
            modifier = Modifier.fillMaxWidth(),
            viewModel = viewModel
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        ) {
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
}

@Composable
private fun LineListHeader(
    modifier: Modifier = Modifier,
    viewModel: LinesViewModel
) {
    Surface(
        modifier = modifier,
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
            MetroLineSelector(
                modifier = Modifier.fillMaxWidth(),
                initIndex = 0,
                lineList = viewModel.lineList,
                onChipClicked = {
                    viewModel.queryStationsForLine(viewModel.lineList[it].lineID)
                }
            )
            // TODO Move this to "About" scene in a future version
            Row {
                val context = LocalContext.current
                val intent = remember {
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/Sokeriaaa/CandyMetroAndroid")
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable {
                            context.startActivity(intent)
                        },
                    text = "Source Code: https://github.com/Sokeriaaa/CandyMetroAndroid",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}