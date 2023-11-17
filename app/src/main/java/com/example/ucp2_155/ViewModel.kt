package com.example.ucp2_155

import androidx.lifecycle.ViewModel
import com.example.ucp2_155.data.FormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModel {
    class OrderViewModel : ViewModel() {
        private val _stateUI = MutableStateFlow(FormUiState())
        val stateUI: StateFlow<FormUiState> = _stateUI.asStateFlow()
    }
    fun setContact(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                NamaMahasiswa = listData[0],
                NIM = listData[1],
                Konsentrasi = listData[2],
                JudulSkripsi = listData[3]
        }
    }
}