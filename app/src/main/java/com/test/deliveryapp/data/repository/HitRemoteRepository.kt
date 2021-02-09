package com.test.deliveryapp.data.repository

import com.test.deliveryapp.data.mapper.HitDtoMapper
import com.test.deliveryapp.data.model.vo.HitVo
import com.test.deliveryapp.data.network.DeliveryApi
import com.test.deliveryapp.domain.RemoteRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class HitRemoteRepository @Inject constructor(private val api: DeliveryApi) :
    RemoteRepository<List<HitVo>> {
    override fun getData(): Single<List<HitVo>> {
        return api.getHits()
            .map { HitDtoMapper.toViewObject(it) }
    }
}