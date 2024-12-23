package com.example.ucp2crud.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailDokterView(
    doctorId: Int,
    viewModel: DetailDokterViewModel = viewModel(),
    it: Any
) {
    val doctor = viewModel.getDoctorById(doctorId).collectAsState(initial = null)

    doctor.value?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nama: ${it.name}")
            Text("Spesialisasi: ${it.specialization}")
            Text("Tempat Praktik: ${it.practicePlace}")
            Text("Kontak: ${it.contact}")
            Text("Jam Tersedia: ${it.availableTime}")
        }
    }
}

