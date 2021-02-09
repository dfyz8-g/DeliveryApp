package com.test.deliveryapp.presentation.restaurant


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.deliveryapp.domain.RestaurantUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class RestaurantViewModel @Inject constructor(private val restaurantUseCase: RestaurantUseCase) :
    ViewModel() {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var restaurants = MutableLiveData<List<RestaurantItem>>()

    init {
        getRestaurants()
    }

    private fun getRestaurants() {
        val disposable = restaurantUseCase
            .getRestaurants()
            .map { it.map { RestaurantItem(it) } }
            .subscribe(
                { restaurants.value = it },
                { it.printStackTrace() }
            )

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}