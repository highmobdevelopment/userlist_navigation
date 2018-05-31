package com.erevacation.widgets.cards

import android.content.Context
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.erevacation.widgets.R
import com.erevacation.widgets.databinding.CardProfileBinding


class ProfileCard : FrameLayout {

    private lateinit var binding: CardProfileBinding

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        binding = DataBindingUtil.inflate(inflater, R.layout.card_profile, this, false)

        val view = binding.root

        this.addView(view)

    }

    fun setProfileDataApperance(data: String, icon: Int, menuField: Int) {
        binding.profileDetails.text = data
        binding.cardName.setText(menuField)
        binding.icons.let { Glide.with(this).load(icon).into(it) }
    }
}