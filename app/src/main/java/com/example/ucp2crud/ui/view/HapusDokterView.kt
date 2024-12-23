package com.example.ucp2crud.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import org.w3c.dom.Text

@Composable
fun HapusDokterView(
    doctorId: Int,
    viewModel: HapusDokterViewModel = viewModel()
) {
    TableInfo.Column(modifier = Modifier.padding(16.dp)) {
        Text("Yakin ingin menghapus dokter ini?")
        Button(onClick = { viewModel.deleteDoctor(doctorId) }) {
            Text("Hapus")
        }
    }
}

