package com.example.ucp2crud.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun <CariDokterViewModel> CariDokterView(viewModel: CariDokterViewModel = viewModel()) {
    val query = remember { mutableStateOf("") }
    val result = viewModel.result.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = query.value, onValueChange = { query.value = it }, label = { Text("Cari Dokter") })
        Button(onClick = { viewModel.cariDokter(query.value) }) {
            Text("Cari")
        }

        result.value.forEach { doctor ->
            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nama: ${doctor.name}")
                    Text("Spesialisasi: ${doctor.specialization}")
                }
            }
        }
    }
}
