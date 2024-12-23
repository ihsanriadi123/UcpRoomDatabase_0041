package com.example.ucp2crud.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2crud.data.repository.DoctorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeDokterViewModel<DoctorEntity>(private val repository: DoctorRepository) : ViewModel() {
    private val _daftarDokter = MutableStateFlow<List<DoctorEntity>>(emptyList())
    val daftarDokter: StateFlow<List<DoctorEntity>> = _daftarDokter

    init {
        loadDokter()
    }

    private fun loadDokter() {
        viewModelScope.launch {
            _daftarDokter.value = repository.getallDokter()
        }
    }
}
