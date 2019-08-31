package com.currency.dependencyinjection

import com.currency.views.ui.activities.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CurrencyActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): HomeActivity
}