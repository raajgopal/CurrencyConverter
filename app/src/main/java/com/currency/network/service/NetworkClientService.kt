package com.currency.network.service

import com.currency.entities.CurrencyValueResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkClientService {
    @GET("/latest")
    fun getCurrencyInfo(@Query("base") base: String): Single<CurrencyValueResponse>
}