package com.example.ucp2crud.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TambahDokterView(viewModel: TambahDokterViewModel = viewModel()) {
    val name = remember { mutableStateOf("") }
    val specialization = remember { mutableStateOf("") }
    val practicePlace = remember { mutableStateOf("") }
    val contact = remember { mutableStateOf("") }
    val availableTime = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name.value, onValueChange = { name.value = it }, label = { Text("Nama Dokter") })
        TextField(value = specialization.value, onValueChange = { specialization.value = it }, label = { Text("Spesialisasi") })
        TextField(value = practicePlace.value, onValueChange = { practicePlace.value = it }, label = { Text("Tempat Praktik") })
        TextField(value = contact.value, onValueChange = { contact.value = it }, label = { Text("Kontak") })
        TextField(value = availableTime.value, onValueChange = { availableTime.value = it }, label = { Text("Jam Tersedia") })
        Button(onClick = {
            val doctor = DoctorEntity(
                name = name.value,
                specialization = specialization.value,
                practicePlace = practicePlace.value,
                contact = contact.value,
                availableTime = availableTime.value
            )
            viewModel.tambahDokter(doctor)
        }) {
            Text("Simpan")
        }
    }
}
