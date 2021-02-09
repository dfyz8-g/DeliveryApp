package com.test.deliveryapp.presentation.restaurant

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.test.deliveryapp.DeliveryApp
import com.test.deliveryapp.databinding.RestaurantFragmentBinding
import com.test.deliveryapp.presentation.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import javax.inject.Inject


class RestaurantFragment :
    BaseFragment<RestaurantFragmentBinding>(RestaurantFragmentBinding::inflate) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: RestaurantViewModel
    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as DeliveryApp).component.inject(this)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[RestaurantViewModel::class.java]

        binding.restaurantsRecyclerview.setHasFixedSize(true)
        binding.restaurantsRecyclerview.setItemViewCacheSize(CACHE_SIZE)

        viewModel.restaurants.observe(viewLifecycleOwner, {
            binding.restaurantsRecyclerview.adapter = adapter.apply { updateAsync(it) }
        })
    }

    companion object {
        fun newInstance() = RestaurantFragment()

        const val CACHE_SIZE = 100
    }
}