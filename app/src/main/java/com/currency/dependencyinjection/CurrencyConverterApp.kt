package com.currency.dependencyinjection

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

class CurrencyConverterApp : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityDispatcher: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentDispatcher: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatcher

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatcher

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        DaggerAppComponent
            .builder()
            .application(this)
            .context(this)
            .build()
            .inject(this)
    }
}