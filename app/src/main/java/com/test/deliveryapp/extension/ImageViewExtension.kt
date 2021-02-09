package com.test.deliveryapp.extension

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImage(path: String?) {
    path?.let {
        Picasso.get()
            .load(it)
            .into(this)
    }
}
