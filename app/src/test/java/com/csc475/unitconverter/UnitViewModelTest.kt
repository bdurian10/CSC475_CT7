package com.csc475.unitconverter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class UnitViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel = UnitViewModel()

    @Test
    fun `do conversion C to F`(){
        viewModel.inputText = "0"
        viewModel.conversionType = UnitViewModel.ConversionType.C_TO_F
        val observer: Observer<String?> = mock()
        viewModel.result.observeForever(observer)
        viewModel.performConversion()
        verify(observer).onChanged("32.0")
    }

    @Test
    fun `do conversion with invalid input`(){
        viewModel.inputText = "abc"
        val observer: Observer<String?> = mock()
        viewModel.error.observeForever(observer)
        viewModel.performConversion()
        verify(observer).onChanged("Invalid input. Please enter a valid number")
    }

    @Test
    fun `do conversion with null input`(){
        viewModel.inputText = ""
        val observer: Observer<String?> = mock()
        viewModel.error.observeForever(observer)
        viewModel.performConversion()
        verify(observer).onChanged("Invalid input. Please enter a valid number")
    }
}