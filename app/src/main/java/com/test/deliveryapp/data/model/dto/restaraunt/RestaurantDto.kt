package com.test.deliveryapp.data.model.dto.restaraunt

data class RestaurantDto(
    val DeliveryCost: Int,
    val DeliveryTime: Int,
    val Logo: String,
    val MinCost: Int,
    val Name: String,
    val PositiveReviews: Int,
    val ReviewsCount: Int,
    val Specializations: List<Specialization>
)