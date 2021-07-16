package dev.olaore.mamopay_exercise.adapters

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import dev.olaore.mamopay_exercise.R

@BindingAdapter(value = ["formattedCurrency", "endsWithPoint"])
fun formattedCurrency(view: TextView, value: String, endsWithPoint: Boolean) {

    var formattedValue = "AED $value"
    var startIndex = 0
    var endIndex = formattedValue.length
    var color = -1

    if (value == "0.00") {
        color = R.color.colorCurrency
    } else if (formattedValue.endsWith(".00")) {
        endIndex = formattedValue.indexOf(".")
        color = R.color.colorBlack
    } else {
        color = R.color.colorBlack
    }

    if (endsWithPoint) {
        endIndex = formattedValue.indexOf(".") + 1
    }

    view.text = formattedValue
    styleText(startIndex, endIndex, view, color)

}

fun styleText(start: Int, end: Int, view: TextView, @ColorRes color: Int) {

    val spannable = SpannableString(view.text)
    spannable.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(view.context, color)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    view.text = spannable

}