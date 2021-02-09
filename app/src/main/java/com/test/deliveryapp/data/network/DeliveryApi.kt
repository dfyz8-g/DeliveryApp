package com.test.deliveryapp.data.network

import com.test.deliveryapp.data.model.dto.ReviewDto
import com.test.deliveryapp.data.model.dto.HitDto
import com.test.deliveryapp.data.model.dto.restaraunt.RestaurantDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface DeliveryApi {
    @GET("restaurants")
    fun getRestaurants(): Single<List<RestaurantDto>>

    @GET("hits")
    fun getHits(): Single<List<HitDto>>

    @GET("reviews")
    fun getReviews(): Single<List<ReviewDto>>
}