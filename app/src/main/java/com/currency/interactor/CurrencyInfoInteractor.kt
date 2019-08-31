package com.currency.interactor

import com.currency.entities.CurrencyValueResponse
import com.currency.repository.NetworkRepository
import io.reactivex.Single
import javax.inject.Inject

class CurrencyInfoInteractor @Inject constructor(private val rateRepository: NetworkRepository) {

    fun getCurrencyRates(base: String): Single<CurrencyValueResponse> {
        return rateRepository.getCurrencyRates(base)
    }
}