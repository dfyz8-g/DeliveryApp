package com.test.deliveryapp.di

import com.test.deliveryapp.DeliveryApp
import com.test.deliveryapp.presentation.restaurant.RestaurantFragment
import com.test.deliveryapp.presentation.review.ReviewFragment
import com.test.deliveryapp.presentation.hit.HitFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(app: DeliveryApp)
    fun inject(restaurantFragment: RestaurantFragment)
    fun inject(hitFragment: HitFragment)
    fun inject(reviewFragment: ReviewFragment)
}
