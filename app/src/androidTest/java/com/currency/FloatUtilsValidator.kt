package com.currency

import com.currency.utils.format
import com.currency.utils.toFloat
import org.junit.Test

class FloatUtilsValidator {
    @Test
    fun testFloatUtils() {
        val s1 = ""
        val float: Float = s1.toFloat()
        float.format()

        val s2 = "."
        val float1: Float = s2.toFloat()
        s2.toFloat()
        float1.format()

        val s3 = "1000.00"
        val float2: Float = s3.toFloat()
        s3.toFloat()
        float2.format()

        val s = "Hellow world"
        s.toFloat()
        val float3: Float = s.toFloat()
        float3.format()
    }
}