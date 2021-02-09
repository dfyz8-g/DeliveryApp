package com.test.deliveryapp.di

import com.test.deliveryapp.DeliveryApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val appContext: DeliveryApp) {
    @Provides
    @Singleton
    fun provideApp() = appContext
}
