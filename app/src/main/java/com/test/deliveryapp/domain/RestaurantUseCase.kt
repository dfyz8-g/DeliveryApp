package com.test.deliveryapp.domain

import com.test.deliveryapp.data.model.dto.restaraunt.RestaurantDto
import com.test.deliveryapp.data.repository.RestaurantRemoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RestaurantUseCase @Inject constructor(
    private val restaurantRemoteRepository: RestaurantRemoteRepository
) {
    fun getRestaurants(): Single<List<RestaurantDto>> =
        restaurantRemoteRepository.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}