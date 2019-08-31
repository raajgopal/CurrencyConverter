package com.currency.dependencyinjection

import com.currency.interactor.CurrencyInfoInteractor
import com.currency.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CurrencyInfoInteractorModule {

    @Singleton
    @Provides
    internal fun providesRateUsecase(rateRepository: NetworkRepository): CurrencyInfoInteractor {
        return CurrencyInfoInteractor(rateRepository)
    }
}