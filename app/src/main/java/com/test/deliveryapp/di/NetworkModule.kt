package com.test.deliveryapp.di

import com.test.deliveryapp.BuildConfig
import com.test.deliveryapp.data.model.dto.restaraunt.RestaurantDto
import com.test.deliveryapp.data.network.DeliveryApi
import com.test.deliveryapp.data.repository.HitRemoteRepository
import com.test.deliveryapp.data.repository.RestaurantRemoteRepository
import com.test.deliveryapp.data.repository.ReviewRemoteRepository
import com.test.deliveryapp.domain.RemoteRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideClient() =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    this.level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    @Singleton
    @Provides
    fun provideDeliveryService(client: OkHttpClient): DeliveryApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(DeliveryApi::class.java)
    }
}
