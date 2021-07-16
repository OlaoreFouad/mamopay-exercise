package dev.olaore.mamopay_exercise.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.olaore.mamopay_exercise.mappers.format

class InputViewModel : ViewModel() {

    var input = MutableLiveData<String>("")

    fun formatCurrency(_input: String) {
        input.postValue(_input.format())
    }

}