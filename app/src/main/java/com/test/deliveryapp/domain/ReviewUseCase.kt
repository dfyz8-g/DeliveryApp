package com.test.deliveryapp.domain

import com.test.deliveryapp.data.model.vo.ReviewVo
import com.test.deliveryapp.data.repository.ReviewRemoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ReviewUseCase @Inject constructor(
    private val reviewRemoteRepository: ReviewRemoteRepository
) {
    fun getReviews(): Single<List<ReviewVo>> =
        reviewRemoteRepository.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}