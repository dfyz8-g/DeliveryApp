package com.test.deliveryapp.presentation.restaurant

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.test.deliveryapp.R
import com.test.deliveryapp.databinding.SearchBarBinding
import com.test.deliveryapp.extension.afterTextChanged

class SearchBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {
    var binding: SearchBarBinding =
        SearchBarBinding.inflate(LayoutInflater.from(context), this, true)
    private val editText: EditText by lazy { binding.searchEditText }
    private var hint: String = ""
    private var isCancelVisible: Boolean = true

    init {
        attrs?.let {
            context.obtainStyledAttributes(attrs, R.styleable.SearchBar).apply {
                hint = getString(R.styleable.SearchBar_hint).orEmpty()
                isCancelVisible = getBoolean(R.styleable.SearchBar_cancel_visible, false)
                recycle()
            }
        }
    }

    fun setText(text: String?) {
        this.editText.setText(text)
    }

    fun clear() {
        this.editText.setText("")
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding.searchEditText.hint = hint
        binding.deleteTextButton.isVisible = false
        binding.deleteTextButton.setOnClickListener {
            clear()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        binding.searchEditText.afterTextChanged { text ->
            binding.deleteTextButton.isVisible = !text.isNullOrEmpty()
        }
    }
}
