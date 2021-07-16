package dev.olaore.mamopay_exercise.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.olaore.mamopay_exercise.mappers.format

class InputViewModel : ViewModel() {

    var input = MutableLiveData<String>("")
    var currentValue = ""

    fun formatCurrency() {
        input.postValue(currentValue.format())
    }

}