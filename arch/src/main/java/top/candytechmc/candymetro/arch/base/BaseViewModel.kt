package top.candytechmc.candymetro.arch.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

/**
 * Base ViewModel
 * @author Sokeriaaa
 * @date 2023/1/17
 */
abstract class BaseViewModel : ViewModel(), KoinComponent {

    var isLoading by mutableStateOf(false)

}