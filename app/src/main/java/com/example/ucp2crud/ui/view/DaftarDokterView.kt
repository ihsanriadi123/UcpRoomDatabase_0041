package com.example.ucp2crud.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DaftarDokterView(viewModel: DaftarDokterViewModel = viewModel()) {
    val doctors = viewModel.allDoctors.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(doctors.value) { doctor ->
            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nama: ${doctor.name}")
                    Text("Spesialisasi: ${doctor.specialization}")
                    Text("Tempat Praktik: ${doctor.practicePlace}")
                }
            }
        }
    }
}
