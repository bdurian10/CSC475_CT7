package com.csc475.unitconverter

class UnitModel {

    fun convertCToF(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    fun convertFToC(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }

    fun convertPoundsToKilos(pounds: Double): Double {
        return pounds * 0.453
    }

    fun convertKilosToPounds(kilos: Double): Double{
        return kilos * 2.205
    }

    fun convertInchesToCentimeters(inches: Double): Double{
        return inches * 2.54
    }

    fun convertCentimetersToInches(centimeters: Double): Double {
        return centimeters / 2.54
    }
}