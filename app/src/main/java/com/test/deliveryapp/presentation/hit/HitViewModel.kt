package com.test.deliveryapp.presentation.hit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.deliveryapp.domain.HitUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class HitViewModel @Inject constructor(private val hitUseCase: HitUseCase) : ViewModel() {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var hits = MutableLiveData<List<HitItem>>()

    init {
        getHints()
    }

    private fun getHints() {
        val disposable = hitUseCase
            .getHits()
            .map { list -> list.map { hitDto -> HitItem(hitDto) } }
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