package com.test.deliveryapp

import androidx.multidex.MultiDexApplication
import com.test.deliveryapp.di.AppComponent
import com.test.deliveryapp.di.AppModule
import com.test.deliveryapp.di.DaggerAppComponent

class DeliveryApp : MultiDexApplication() {
    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        component.inject(this)
    }

    companion object {
        var instance: DeliveryApp? = null
            private set
    }
}