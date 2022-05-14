package com.rorono.composition.presentation


import android.content.Context
import android.content.res.ColorStateList
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.rorono.composition.R


interface OnOptionOnClickListener {
    fun onOptionClick(option: Int)
}

@BindingAdapter("app:requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        "%s %d", textView.context.getString(R.string.required_scope),
        count
    )
}

@BindingAdapter("scopeAnswer")
fun bindScopeAnswer(textView: TextView, count: Int) {
    textView.text = String.format("%s %d", textView.context.getString(R.string.scope_answer), count)
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, count: Int) {
    textView.text =
        String.format("%s %d", textView.context.getString(R.string.required_percentage), count)
}

@BindingAdapter("sum")
fun bindTvSum(textView: TextView, count: Int) {
    textView.text = count.toString()
}

@BindingAdapter("visibleNumber")
fun bindTvLeftNumber(textView: TextView, count: Int) {
    textView.text = count.toString()
}

@BindingAdapter("enoughCountOfRightAnswers")
fun bindTvAnswersProgress(textView: TextView, enough: Boolean) {
    textView.setTextColor(getColorByState(textView.context, enough))
}

@BindingAdapter("enoughPercent")
fun bindTvAnswersEnoughPercent(progressBar: ProgressBar, enough: Boolean) {
    val color = getColorByState(progressBar.context, enough)
    progressBar.progressTintList = ColorStateList.valueOf(color)

}

@BindingAdapter("onClickListener")
fun bindOptionClickListener(textView: TextView, clickListener: OnOptionOnClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}


private fun getColorByState(context: Context, gooState: Boolean): Int {
    val colorResId = if (gooState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_dark
    }
    return ContextCompat.getColor(context, colorResId)
}
