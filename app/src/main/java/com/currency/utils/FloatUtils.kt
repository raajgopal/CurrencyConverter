package com.currency.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.ParseException
import java.util.*

fun String.toFloat(): Float = if (isNullOrBlank()) {
    0F
} else {
    try {

        DecimalFormat("0.#", DecimalFormatSymbols.getInstance(Locale.getDefault())).parse(this).toFloat()
    } catch (e: ParseException) {
        0F
    }
}

/**
 * Format the float to string
 * Locale safe
 */
fun Float.format(): String = String.format(Locale.getDefault(), "%.2f", this)