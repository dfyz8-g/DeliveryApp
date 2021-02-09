package com.test.deliveryapp.data.model.dto


import com.google.gson.annotations.SerializedName

data class HitDto(
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