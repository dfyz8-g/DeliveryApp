package com.test.deliveryapp.extension

import android.text.Editable
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

fun EditText.afterTextChanged(action: (s: Editable?) -> Unit) =
    addTextChangedListener(afterTextChanged = action)
