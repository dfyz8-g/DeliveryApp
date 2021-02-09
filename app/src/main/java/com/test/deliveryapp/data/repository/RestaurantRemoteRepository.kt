package com.test.deliveryapp.data.repository

import com.test.deliveryapp.data.model.dto.restaraunt.RestaurantDto
import com.test.deliveryapp.data.network.DeliveryApi
import com.test.deliveryapp.domain.RemoteRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RestaurantRemoteRepository @Inject constructor(private val api: DeliveryApi) :
    RemoteRepository<List<RestaurantDto>> {
    override fun getData(): Single<List<RestaurantDto>> {
        return api.getRestaurants()
    }
}