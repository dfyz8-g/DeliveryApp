package com.test.deliveryapp.presentation.restaurant

import android.view.View
import com.test.deliveryapp.R
import com.test.deliveryapp.data.model.dto.restaraunt.RestaurantDto
import com.test.deliveryapp.databinding.RestaurantItemBinding
import com.test.deliveryapp.extension.loadImage

import com.xwray.groupie.viewbinding.BindableItem


class RestaurantItem(
    private val content: RestaurantDto,
) : BindableItem<RestaurantItemBinding>() {

    override fun getLayout() = R.layout.restaurant_item

    override fun bind(viewBinding: RestaurantItemBinding, position: Int) {
        viewBinding.restaurantLogoIv.loadImage(content.Logo)
        viewBinding.restaurantNameTv.text = content.Name
        viewBinding.restaurantSpecializationTv.text = content
            .Specializations.joinToString(separator = "/") { it.Name }
    }

    override fun initializeViewBinding(view: View): RestaurantItemBinding =
        RestaurantItemBinding.bind(view)

}