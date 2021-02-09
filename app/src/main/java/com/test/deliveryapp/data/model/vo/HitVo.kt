package com.test.deliveryapp.data.model.vo

import com.google.gson.annotations.SerializedName

data class HitVo (
    @SerializedName("ProductDescription")
    val productDescription: String?,
    @SerializedName("ProductImage")
    val productImage: String?,
    @SerializedName("ProductName")
    val productName: String?,
    @SerializedName("ProductPrice")
    val productPrice: Int?,
    @SerializedName("RestaurantId")
    val restaurantId: Int?,
    @SerializedName("RestaurantLogo")
    val restaurantLogo: String?,
    @SerializedName("RestaurantName")
    val restaurantName: String?
)