package com.example.ucp2crud.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UpdateDokterView(
    doctorId: Int,
    viewModel: UpdateDokterViewModel = viewModel(),
    it: String
) {
    val doctor = viewModel.getDoctorById(doctorId).collectAsState(initial = null)
    val updatedName = remember { mutableStateOf("") }
    val updatedSpecialization = remember { mutableStateOf("") }

    doctor.value?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            TextField(value = updatedName.value, onValueChange = { updatedName.value = it }, label = { Text("Nama Baru") })
            TextField(value = updatedSpecialization.value, onValueChange = { updatedSpecialization.value = it }, label = { Text("Spesialisasi Baru") })
            Button(onClick = {
                viewModel.updateDoctor(it.copy(name = updatedName.value, specialization = updatedSpecialization.value))
            }) {
                Text("Perbarui")
            }
        }
    }
}

