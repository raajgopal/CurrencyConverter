package com.currency.views.ui.contract

import com.currency.entities.CountryCurrencyInfo

interface CurrencyViewContract {

    /**
     * Update the rates
     */
    fun updateCurrencyRatesList(rates: ArrayList<CountryCurrencyInfo>)

    /**
     * Update the amount in each EditText
     */
    fun updateCurrencyAmount(amount: Float)

    /**
     * Show or hide the loader
     */
    fun showLoading(isLoading: Boolean)

    /**
     * Show an error message
     */
    fun showErrorMessage()
}