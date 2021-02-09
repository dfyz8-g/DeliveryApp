package com.test.deliveryapp.presentation.hit

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import com.test.deliveryapp.R
import com.test.deliveryapp.data.model.vo.HitVo
import com.test.deliveryapp.databinding.HitItemBinding
import com.test.deliveryapp.extension.loadImage
import com.xwray.groupie.viewbinding.BindableItem

class HitItem(
    private val content: HitVo,
) : BindableItem<HitItemBinding>() {

    override fun getLayout() = R.layout.hit_item

    override fun bind(viewBinding: HitItemBinding, position: Int) {
        viewBinding.hitImage.loadImage(content.productImage)
        viewBinding.hitNameTv.text = content.productName
        viewBinding.root.setOnLongClickListener {

            true
        }
    }

    override fun initializeViewBinding(view: View): HitItemBinding =
        HitItemBinding.bind(view)
}