package com.test.deliveryapp.presentation.hit

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.test.deliveryapp.DeliveryApp
import com.test.deliveryapp.databinding.HitFragmentBinding
import com.test.deliveryapp.presentation.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import javax.inject.Inject


class HitFragment : BaseFragment<HitFragmentBinding>(HitFragmentBinding::inflate) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: HitViewModel
    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as DeliveryApp).component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[HitViewModel::class.java]

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.hitsRecyclerview.layoutManager =
            layoutManager//CenterZoomLayoutManager(requireContext())
        binding.hitsRecyclerview.setHasFixedSize(true)
        binding.hitsRecyclerview.setItemViewCacheSize(CACHE_SIZE)

        viewModel.hits.observe(viewLifecycleOwner, {
            binding.hitsRecyclerview.adapter = adapter.apply { updateAsync(it) }
        })
    }

    companion object {
        fun newInstance() = HitFragment()

        const val CACHE_SIZE = 100
    }
}