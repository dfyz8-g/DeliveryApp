package com.test.deliveryapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.deliveryapp.presentation.review.ReviewViewModel
import com.test.deliveryapp.presentation.restaurant.RestaurantViewModel
import com.test.deliveryapp.presentation.hit.HitViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T
}

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantViewModel::class)
    abstract fun restaurantViewModel(viewModel: RestaurantViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HitViewModel::class)
    abstract fun hitViewModel(viewModel: HitViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReviewViewModel::class)
    abstract fun reviewViewModelViewModel(viewModel: ReviewViewModel): ViewModel
}
