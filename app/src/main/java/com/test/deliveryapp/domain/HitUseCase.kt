package com.test.deliveryapp.domain

import com.test.deliveryapp.data.model.dto.HitDto
import com.test.deliveryapp.data.model.vo.HitVo
import com.test.deliveryapp.data.repository.HitRemoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HitUseCase @Inject constructor(
    private val hitRemoteRepository: HitRemoteRepository
) {
    fun getHits(): Single<List<HitVo>> {
        return hitRemoteRepository.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
