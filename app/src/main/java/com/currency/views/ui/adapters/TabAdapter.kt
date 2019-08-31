package com.currency.views.ui.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.currency.R
import com.currency.views.ui.fragments.CurrencyInfoFragment
import com.currency.views.ui.fragments.CurrencyRatesFragment

class TabAdapter(val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    companion object {
        const val TabRates = 0
        const val TabConverter = 1
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            TabRates -> CurrencyRatesFragment()
            TabConverter -> CurrencyInfoFragment()
            else -> error(
                "there is no type that matches the position $position + make sure your using adapter correctly"
            )
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            TabRates -> context.getString(R.string.title_rates)
            TabConverter -> context.getString(R.string.title_converter)
            else -> ""
        }
    }

}