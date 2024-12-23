package com.example.ucp2crud.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2crud.data.repository.DoctorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailDokterViewModel<DoctorEntity>(private val repository: DoctorRepository) : ViewModel() {
    private val _detailDokter = MutableStateFlow<DoctorEntity?>(null)
    val detailDokter: StateFlow<DoctorEntity?> = _detailDokter

    fun getDetailDokter(id: Int) {
        viewModelScope.launch {
            _detailDokter.value = repository.getDoctorById(id)
        }
    }
}
