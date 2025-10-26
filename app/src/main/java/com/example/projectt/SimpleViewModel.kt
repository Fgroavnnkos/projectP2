package com.example.projectt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    val currentNumber = MutableLiveData("0")
    val randomNumber = MutableLiveData(0)
}