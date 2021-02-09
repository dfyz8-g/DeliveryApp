package com.test.deliveryapp.data.mapper

import com.test.deliveryapp.data.model.dto.HitDto
import com.test.deliveryapp.data.model.vo.HitVo

object HitDtoMapper :
    ViewObjectMapper<HitVo, HitDto> {
    override fun toViewObject(dto: HitDto): HitVo {
        return HitVo(
            dto.productDescription,
            dto.productImage,
            dto.productName?.toLowerCase()?.capitalize()?.trim(),
            dto.productPrice,
            dto.restaurantId,
            dto.restaurantLogo,
            dto.restaurantName,
        )
    }
}
