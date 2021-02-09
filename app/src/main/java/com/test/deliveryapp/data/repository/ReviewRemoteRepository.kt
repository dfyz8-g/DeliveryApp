package com.test.deliveryapp.data.repository

import com.test.deliveryapp.data.mapper.ReviewDtoMapper
import com.test.deliveryapp.data.model.vo.ReviewVo
import com.test.deliveryapp.data.network.DeliveryApi
import com.test.deliveryapp.domain.RemoteRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ReviewRemoteRepository @Inject constructor(private val api: DeliveryApi) :
    RemoteRepository<List<ReviewVo>> {
    override fun getData(): Single<List<ReviewVo>> {
        return api.getReviews()
            .map { ReviewDtoMapper.toViewObject(it) }
    }
}