package com.currency.entities

data class CurrencyValueResponse(val base: String, val date: String, val rates: Map<String, Float>)