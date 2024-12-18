package com.example.ucp2crud.data.database

import android.content.Context
import androidx.room.Database
import com.example.ucp2crud.data.dao.DokterDao
import com.example.ucp2crud.data.entity.Dokter

@Database(entities = [Dokter::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    //Medefinisikan fungsi untuk mengakses data mahasiswa
    abstract fun  DokterDao(): DokterDao

    companion object{
        @Volatile // memastikan bahawa nilai variabel instance selalu sama di semua
        private var  Instances: AppDatabase? = null


        fun getDatabase(context: Context, Room: Any, it: AppDatabase?): AppDatabase{
            return (Instances ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "KrsDatabase"
                )
                    .build().also { Instances =it }
            })
        }
    }
}
