package com.currency.respository

import com.currency.entities.CurrencyValueResponse
import com.currency.network.service.NetworkClientService
import com.currency.respository.contract.RepositoryStore
import io.reactivex.Single
import javax.inject.Inject

class ApiStore @Inject constructor(private val networkClientService: NetworkClientService) : RepositoryStore {

    override fun getCurrencyRates(base: String): Single<CurrencyValueResponse> {
        return networkClientService.getCurrencyInfo(base)
    }
}