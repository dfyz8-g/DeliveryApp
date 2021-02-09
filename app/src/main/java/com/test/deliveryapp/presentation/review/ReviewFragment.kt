package com.test.deliveryapp.presentation.review

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.test.deliveryapp.DeliveryApp
import com.test.deliveryapp.R
import com.test.deliveryapp.databinding.ReviewFragmentBinding
import com.test.deliveryapp.presentation.BaseFragment
import com.test.deliveryapp.presentation.hit.HitFragment
import com.test.deliveryapp.presentation.hit.HitViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import javax.inject.Inject

class ReviewFragment : BaseFragment<ReviewFragmentBinding>(ReviewFragmentBinding::inflate) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ReviewViewModel
    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as DeliveryApp).component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ReviewViewModel::class.java]

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getReviews()
        }

        binding.reviewsRecyclerview.setHasFixedSize(true)
        binding.reviewsRecyclerview.setItemViewCacheSize(CACHE_SIZE)

        viewModel.hits.observe(viewLifecycleOwner, {
            binding.reviewsRecyclerview.adapter = adapter.apply { updateAsync(it) }
            binding.swipeRefresh.isRefreshing = false
        })
    }

    companion object {
        fun newInstance() = ReviewFragment()

        const val CACHE_SIZE = 100
    }
}