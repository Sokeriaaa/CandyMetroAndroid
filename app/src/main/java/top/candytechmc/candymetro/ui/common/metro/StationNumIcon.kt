package top.candytechmc.candymetro.ui.common.metro

import androidx.annotation.ColorInt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

/**
 * Draw a station number icon
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun StationNumIcon(
    modifier: Modifier = Modifier,
    lineID: Int,
    stationID: Int,
    @ColorInt
    lineColorInt: Int
) {
    Canvas(modifier = modifier) {
        // Canvas width
        val cw = size.width.absoluteValue
        // Canvas height
        val ch = size.height.absoluteValue

        // Canvas center X
        val cx = cw / 2
        // Canvas center Y
        val cy = ch / 2

        // Circle width
        val circleWidth = size.minDimension / 2

        // Line color
        val lineColor = Color(color = lineColorInt + 0xFF000000)

        // Circles
        drawCircle(
            color = Color.Black,
            radius = circleWidth,
        )
        drawCircle(
            color = Color.White,
            radius = circleWidth * .94f
        )
        drawCircle(
            color = lineColor,
            radius = circleWidth * .90f
        )
        drawCircle(
            color = Color.White,
            radius = circleWidth * .80f
        )

        drawRect(
            color = lineColor,
            topLeft = Offset(
                x = cx - circleWidth * .72f,
                y = cy - circleWidth * .03f
            ),
            size = Size(
                width = circleWidth * 1.44f,
                height = circleWidth * .06f
            )
        )

        val textPaint = android.graphics.Paint().apply {
            isAntiAlias = true
            textAlign = android.graphics.Paint.Align.CENTER
            color = android.graphics.Color.BLACK
        }

        // Draw line number
        drawIntoCanvas {
            it.nativeCanvas.apply {
                drawText(
                    lineID.toString(),
                    cx,
                    cy - circleWidth * .12f,
                    textPaint.also { paint ->
                        paint.textSize = circleWidth * .72f
                    }
                )
            }
        }

        // Draw station number
        drawIntoCanvas {
            it.nativeCanvas.apply {
                drawText(
                    stationID.toString().padStart(length = 2, padChar = '0'),
                    cx,
                    cy + circleWidth * .60f,
                    textPaint.also { paint ->
                        paint.textSize = circleWidth * .64f
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun Test() {
    StationNumIcon(
        modifier = Modifier.requiredSize(100.dp),
        lineID = 1,
        stationID = 13,
        lineColorInt = 0xFF99FF
    )
}