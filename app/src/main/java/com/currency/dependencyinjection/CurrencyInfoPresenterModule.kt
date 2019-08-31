package com.currency.dependencyinjection

import com.currency.interactor.CurrencyInfoInteractor
import com.currency.presenter.CurrencyInfoPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CurrencyInfoPresenterModule {

    @Singleton
    @Provides
    internal fun providesConverterPresenter(rateUsecase: CurrencyInfoInteractor): CurrencyInfoPresenter {
        return CurrencyInfoPresenter(rateUsecase)
    }
}