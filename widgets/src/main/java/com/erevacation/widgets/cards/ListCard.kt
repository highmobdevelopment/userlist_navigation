package com.erevacation.widgets.cards

import android.content.Context
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.erevacation.widgets.R
import com.erevacation.widgets.databinding.CardListBinding


class ListCard : FrameLayout {

    private lateinit var binding: CardListBinding

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        binding = DataBindingUtil.inflate(inflater, R.layout.card_list, this, false)

        val view = binding.root

        this.addView(view)

    }

    fun setListApperance(name: String, surname: String, url: String) {
        val fullName: String = "$name $surname"
        binding.profileText.text = fullName
        binding.profileImage.let { Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(it) }
    }
}