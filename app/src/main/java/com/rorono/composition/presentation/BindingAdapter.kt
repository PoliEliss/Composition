package com.rorono.composition.presentation


import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.rorono.composition.R


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
    textView.text = String.format("%s %d", textView.context.getString(R.string.required_percentage),count)
}