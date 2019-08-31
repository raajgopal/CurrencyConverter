package com.currency.views.ui.listeners

interface OnCurrencyValueChangedListener {

    /**
     * Function called when the user changed the amount for the given currency symbol.
     *
     */
    fun onCurrencyAmountChanged(symbol: String, amount: Float)
}