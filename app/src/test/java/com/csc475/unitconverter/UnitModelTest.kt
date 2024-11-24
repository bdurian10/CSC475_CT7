package com.csc475.unitconverter

import org.junit.Assert.*
import org.junit.Test

class UnitModelTest {

    private val unitModel = UnitModel()

    @Test
    fun `convert Celsius to Fahrenheit`() {
        val celsius = 0.0
        val result = unitModel.convertCToF(celsius)
        assertEquals(32.0, result, 0.001)
    }

    @Test
    fun `convert Celsius to Fahrenheit High`() {
        val celsius = 20000.0
        val result = unitModel.convertCToF(celsius)
        assertEquals(36032.0, result, 0.001)
    }

    @Test
    fun `convert Fahrenheit to Celsius`() {
        val fahrenheit = 32.0
        val result = unitModel.convertFToC(fahrenheit)
        assertEquals(0.0, result, 0.001)
    }

    @Test
    fun `convert Pounds to Kilograms`(){
        val pounds = 10.0
        val result = unitModel.convertPoundsToKilos(pounds)
        assertEquals(4.53, result, 0.001)
    }

    @Test
    fun `convert Kilograms to Pounds`(){
        val kilos = 10.0
        val result = unitModel.convertKilosToPounds(kilos)
        assertEquals(22.05, result, 0.001)
    }

    @Test
    fun `convert Inches to Centimeters`(){
        val inches = 1.0
        val result = unitModel.convertInchesToCentimeters(inches)
        assertEquals(2.54, result, 0.001)
    }

    @Test
    fun `convert Centimeters to Inches`(){
        val centimeters = 2.54
        val result = unitModel.convertCentimetersToInches(centimeters)
        assertEquals(1.0, result, 0.001)
    }

}