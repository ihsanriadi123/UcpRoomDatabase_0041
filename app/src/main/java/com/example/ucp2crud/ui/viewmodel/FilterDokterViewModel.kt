package com.example.ucp2crud.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2crud.data.repository.DoctorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilterDokterViewModel<DoctorEntity>(private val repository: DoctorRepository) : ViewModel() {
    private val _dokterTersaring = MutableStateFlow<List<DoctorEntity>>(emptyList())
    val dokterTersaring: StateFlow<List<DoctorEntity>> = _dokterTersaring

    fun filterBerdasarkanSpesialisasi(spesialisasi: String) {
        viewModelScope.launch {
            _dokterTersaring.value = repository.getDoctorsBySpecialization(spesialisasi)
        }
    }
}
