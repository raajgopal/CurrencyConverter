package com.currency.presenter

import android.annotation.SuppressLint
import com.currency.entities.CountryCurrencyInfo
import com.currency.interactor.CurrencyInfoInteractor
import com.currency.views.ui.contract.CurrencyViewContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrencyInfoPresenter @Inject constructor(private val currencyInfo: CurrencyInfoInteractor) {
    companion object {
        const val DEFAULT_SYMBOL = "EUR"
    }

    lateinit var currencyView: CurrencyViewContract

    private var currentBase: String = ""
    private var viewStopped = false
    private var isLoaded = false

    @SuppressLint("CheckResult")
            /**
             * Update the rates using the given symbol; or simply update the amount
             */
    fun evaluateRates(base: String, amount: Float) {
        if (base.equals(currentBase, ignoreCase = true)) {
            currencyView.updateCurrencyAmount(amount)
        } else {
            currentBase = base.toUpperCase()
            currencyInfo.getCurrencyRates(base)
                .doOnSubscribe {
                    if (!isLoaded) {
                        currencyView.showLoading(true)
                    }
                }
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .repeatUntil { viewStopped || !base.equals(currentBase, ignoreCase = true) }
                .subscribe({
                    val rates = ArrayList<CountryCurrencyInfo>()
                    rates.add(CountryCurrencyInfo(it.base, 1F))
                    rates.addAll(it.rates.map { CountryCurrencyInfo(it.key, it.value) })

                    currencyView.updateCurrencyRatesList(rates)
                    if (!isLoaded) {
                        currencyView.showLoading(false)
                    }
                    isLoaded = true
                }, {
                    currencyView.showErrorMessage()
                })
        }
    }


    fun onActivityCreated() {
        evaluateRates(DEFAULT_SYMBOL, 1F)
    }


    fun onDestroy() {
        viewStopped = true
    }
}