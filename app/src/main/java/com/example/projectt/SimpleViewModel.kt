package com.example.projectt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    val currentNumber = MutableLiveData(0)
    val randomNumber = MutableLiveData(0)

    fun plusOne() {
        val its = currentNumber.value
        currentNumber.value = (its?.plus(1))
    }
}