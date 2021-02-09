package com.test.deliveryapp.data.mapper

import com.test.deliveryapp.data.model.dto.ReviewDto
import com.test.deliveryapp.data.model.vo.ReviewVo

object ReviewDtoMapper : ViewObjectMapper<ReviewVo, ReviewDto> {
    override fun toViewObject(dto: ReviewDto): ReviewVo {
        return ReviewVo(
            dto.dateAdded,
            dto.isPositive,
            dto.message?.trim(),
            dto.restaurantName?.trim(),
            dto.userFIO?.trim()
        )
    }
}