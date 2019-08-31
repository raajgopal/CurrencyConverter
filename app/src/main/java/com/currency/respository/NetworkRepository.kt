package com.currency.respository

import com.currency.entities.CurrencyValueResponse
import io.reactivex.Single
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val repositoryDatastore: ApiStore) {

    /**
     * Returns the rates using a base symbol
     */
    fun getCurrencyRates(base: String): Single<CurrencyValueResponse> {
        return repositoryDatastore.getCurrencyRates(base)
    }
}

