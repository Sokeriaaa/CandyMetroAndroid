package top.candytechmc.candymetro.arch.utils

import androidx.annotation.ColorInt
import androidx.compose.ui.graphics.Color
import android.graphics.Color as NativeColor

object ColorUtils {
    fun getForegroundColorFrom(backgroundColor: Color): Color {
        val grayLevel =
            backgroundColor.red * 0.299 + backgroundColor.green * 0.587 + backgroundColor.blue * 0.114
        return if (grayLevel >= 200) {
            Color.Black
        } else {
            Color.White
        }
    }

    @ColorInt
    fun getForegroundColorFrom(@ColorInt backgroundColor: Int): Int {
        val grayLevel =
            ((backgroundColor and 0xFF0000 shr 16) * 0.299) +
                    ((backgroundColor and 0x00FF00 shr 8) * 0.587) +
                    ((backgroundColor and 0x0000FF) * 0.114)
        return if (grayLevel >= 200) {
            NativeColor.BLACK
        } else {
            NativeColor.WHITE
        }
    }
}