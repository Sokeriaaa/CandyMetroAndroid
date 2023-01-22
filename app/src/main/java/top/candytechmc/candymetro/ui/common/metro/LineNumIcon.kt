package top.candytechmc.candymetro.ui.common.metro

import androidx.annotation.ColorInt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.candytechmc.candymetro.arch.utils.ColorUtils
import kotlin.math.absoluteValue

/**
 * Draw a station number icon
 * @author Sokeriaaa
 * @date 2023/1/17
 */
@OptIn(ExperimentalTextApi::class)
@Composable
fun LineNumIcon(
    modifier: Modifier = Modifier,
    lineID: Int,
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
            color = lineColor,
            radius = circleWidth,
        )

        val textPaint = android.graphics.Paint().apply {
            isAntiAlias = true
            textAlign = android.graphics.Paint.Align.CENTER
            color = ColorUtils.getForegroundColorFrom(lineColorInt)
        }

        // Draw line number
        drawIntoCanvas {
            textPaint.textSize = circleWidth * 1.28f

            val drawString = lineID.toString()
            val yOffset = with(textPaint.fontMetrics) {
                (bottom + top) / 2
            }

            it.nativeCanvas.apply {
                drawText(
                    drawString,
                    cx,
                    cy - yOffset,
                    textPaint
                )
            }
        }
    }
}

@Preview
@Composable
private fun Test() {
    LineNumIcon(
        modifier = Modifier.requiredSize(100.dp),
        lineID = 1,
        lineColorInt = 0xFF99FF
    )
}