package com.example.ucp2crud.data.repository

import com.example.ucp2crud.data.dao.DokterDao
import com.example.ucp2crud.data.entity.Dokter

class DoctorRepository(private val dokterDao: DokterDao) {
    val allDokter = dokterDao.getAllDokter()

    suspend fun insert(dokter: Dokter) {
        dokterDao.insert(dokter)
    }

    suspend fun delete(dokter: Dokter) {
        dokterDao.delete(dokter)
    }
}
