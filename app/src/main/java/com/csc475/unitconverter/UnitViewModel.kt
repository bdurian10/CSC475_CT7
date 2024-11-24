package com.csc475.unitconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UnitViewModel: ViewModel() {
    private val unitModel = UnitModel()

    private val _result = MutableLiveData<String?>()
    val result: LiveData<String?> get() = _result

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    var inputText: String = ""
    var conversionType: ConversionType = ConversionType.C_TO_F

    fun performConversion(){
        try{
            val input = inputText.toDoubleOrNull()
            if(input == null) {
                _error.value = "Invalid input. Please enter a valid number"
                return
            }

            val conversionResult = when(conversionType){
                ConversionType.C_TO_F -> unitModel.convertCToF(input)
                ConversionType.F_TO_C -> unitModel.convertFToC(input)
                ConversionType.POUNDS_TO_KILOS -> unitModel.convertPoundsToKilos(input)
                ConversionType.KILOS_TO_POUNDS -> unitModel.convertKilosToPounds(input)
                ConversionType.INCHES_TO_CM -> unitModel.convertInchesToCentimeters(input)
                ConversionType.CM_TO_INCHES -> unitModel.convertCentimetersToInches(input)
            }

            _result.value = "%.1f".format(conversionResult)
            _error.value = null
        } catch(e: Exception){
            _error.value = "An error occurred. Please try again."
        }
    }

    enum class ConversionType{
        C_TO_F, F_TO_C, POUNDS_TO_KILOS, KILOS_TO_POUNDS, INCHES_TO_CM, CM_TO_INCHES
    }
}

