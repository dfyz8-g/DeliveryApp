package com.test.deliveryapp.presentation.review

import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import com.test.deliveryapp.R
import com.test.deliveryapp.data.model.vo.ReviewVo
import com.test.deliveryapp.databinding.ReviewItemBinding
import com.xwray.groupie.viewbinding.BindableItem
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ReviewItem(
    private val content: ReviewVo,
) : BindableItem<ReviewItemBinding>() {
    override fun getLayout() = R.layout.review_item

    override fun bind(viewBinding: ReviewItemBinding, position: Int) {
        setReviewTitle(viewBinding)
        viewBinding.reviewMessageTv.text = content.message
        viewBinding.reviewDateTv.text = formattedDate(content.dateAdded)
    }

    private fun setReviewTitle(viewBinding: ReviewItemBinding) {
        viewBinding.reviewTitleTv.text = titleString(viewBinding)
        setTitleDrawable(viewBinding)
    }

    private fun setTitleDrawable(viewBinding: ReviewItemBinding) {
        val startDrawable = titleDrawable(viewBinding)
        viewBinding.reviewTitleTv.setCompoundDrawablesWithIntrinsicBounds(
            startDrawable,
            null,
            null,
            null
        )
    }

    private fun titleDrawable(viewBinding: ReviewItemBinding): Drawable? {
        return if (content?.isPositive == true) {
            ContextCompat.getDrawable(viewBinding.root.context, R.drawable.ic_restautant_like_icon)
        } else {
            ContextCompat.getDrawable(viewBinding.root.context, R.drawable.ic_dislike_icon)
        }
    }

    private fun titleString(viewBinding: ReviewItemBinding): String {
        val aboutRestaurantString =
            viewBinding.root.context.getString(R.string.review_about_restaurant_string)
        return content.userFIO + aboutRestaurantString + content.restaurantName
    }

    private fun formattedDate(date: String?): String {
        return try {
            val ss = date?.substring(date.lastIndexOf("."), date.length)
            val ldt: LocalDateTime =
                LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss$ss"))
            val currentZoneId: ZoneId = ZoneId.systemDefault()
            val currentZonedDateTime: ZonedDateTime = ldt.atZone(currentZoneId)
            val format: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

            format.format(currentZonedDateTime)
        } catch (e: Exception) {
            ""
        }
    }

    override fun initializeViewBinding(view: View): ReviewItemBinding =
        ReviewItemBinding.bind(view)
}

