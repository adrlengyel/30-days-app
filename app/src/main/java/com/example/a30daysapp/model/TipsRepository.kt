package com.example.a30daysapp.model

import com.example.a30daysapp.R

object TipsRepository{
    val tips = {
        Tip(
            R.string.spend_more_time_in_nature,
            R.string.spend_more_time_in_nature_description,
            R.drawable.spend_more_time_in_nature
        )
        Tip(
            R.string.spend_less_time_on_your_phone,
            R.string.spend_less_time_on_your_phone_description,
            R.drawable.spend_less_time_on_phone
        )
        Tip(
            R.string.eat_cleaner_foods,
            R.string.eat_cleaner_foods_description,
            R.drawable.eat_cleaner_foods
        )
    }
}