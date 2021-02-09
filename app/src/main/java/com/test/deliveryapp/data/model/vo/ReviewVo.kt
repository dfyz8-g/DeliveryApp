package com.test.deliveryapp.data.model.vo


import com.google.gson.annotations.SerializedName

data class ReviewVo(
    @SerializedName("DateAdded")
    val dateAdded: String?,
    @SerializedName("IsPositive")
    val isPositive: Boolean?,
    @SerializedName("Message")
    val message: String?,
    @SerializedName("RestaurantName")
    val restaurantName: String?,
    @SerializedName("UserFIO")
    val userFIO: String?
)