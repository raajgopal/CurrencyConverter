package com.currency.dependencyinjection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CurrencyActivityModule::class,
        CurrencyInfoFragmentModule::class,
        ApiModule::class,
        RepositoryModule::class]
)
interface AppComponent {

    fun inject(application: CurrencyConverterApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}