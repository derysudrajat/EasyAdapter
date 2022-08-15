package id.derysudrajat.exampleeasyadapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Data>>()
    val data get() = _data

    private val _dataAnother = MutableLiveData<List<Data>>()
    val dataAnother get() = _dataAnother
    private var index = 0

    fun changeData() {
        if (index == 0) getNumber() else getData()
        index = if (index == 0) 1 else 0
    }

    fun getData() {
        viewModelScope.launch {
            _data.value = Dummy.example
        }
    }

    fun getAnotherData() {
        viewModelScope.launch {
            _dataAnother.value = Dummy.anotherExample
        }
    }

    private fun getNumber() {
        viewModelScope.launch {
            _data.value = Dummy.anotherExample
        }
    }
}