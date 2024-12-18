package com.example.ucp2crud.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2crud.data.entity.Dokter

@Dao
interface DokterDao {
    @Insert
    suspend fun insertDokter(dokter: Dokter)

    @Query("SELECT * FROM dokter ORDER BY nama ASC")
    suspend fun getAllDokter(): List<Dokter>

    @Query("SELECT * FROM dokter WHERE id = :id")
    suspend fun getDokterById(id: Int): Dokter

    @Delete
    suspend fun deleteDokter(dokter: Dokter)

    @Update
    suspend fun updateDokter(dokter: Dokter)
}
