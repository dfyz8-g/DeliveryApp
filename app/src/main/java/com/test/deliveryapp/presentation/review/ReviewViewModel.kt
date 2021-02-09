package com.test.deliveryapp.presentation.review

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.deliveryapp.domain.RestaurantUseCase
import com.test.deliveryapp.domain.ReviewUseCase
import com.test.deliveryapp.presentation.hit.HitItem
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class ReviewViewModel @Inject constructor(private val reviewUseCase: ReviewUseCase) :
    ViewModel() {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var hits = MutableLiveData<List<ReviewItem>>()

    init {
        getReviews()
    }

    fun getReviews() {
        val disposable = reviewUseCase
            .getReviews()
            .map { list -> list.map { reviewVo -> ReviewItem(reviewVo) } }
            .subscribe(
                { hits.value = it },
                { it.printStackTrace() }
            )

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}