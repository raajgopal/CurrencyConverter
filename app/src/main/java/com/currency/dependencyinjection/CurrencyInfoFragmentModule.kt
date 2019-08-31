package com.currency.dependencyinjection

import com.currency.views.ui.fragments.CurrencyInfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CurrencyInfoFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun currencyConverterFragment(): CurrencyInfoFragment
}
