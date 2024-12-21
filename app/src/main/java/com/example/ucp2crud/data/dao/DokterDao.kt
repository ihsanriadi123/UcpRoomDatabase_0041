package com.example.ucp2crud.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp2crud.data.entity.Dokter
import kotlinx.coroutines.flow.Flow

@Dao
interface DokterDao {
    @Insert
    suspend fun insertDokter(dokter: Dokter)

    //get All Dokter
    @Query("SELECT * FROM dokter ORDER BY nama ASC")
    fun getAllDokter(): Flow<List<Dokter>>

}

