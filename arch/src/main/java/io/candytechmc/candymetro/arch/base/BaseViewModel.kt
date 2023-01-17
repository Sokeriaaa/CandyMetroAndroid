package io.candytechmc.candymetro.arch.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    var isLoading by mutableStateOf(false)

}