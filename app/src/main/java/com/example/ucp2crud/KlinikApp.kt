package com.example.ucp2crud

import android.app.Application


class KrsApp<ContainerApp> :Application() {
    lateinit var containerApp: ContainerApp // fungsinya untuk menyimpan instance

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}
