package com.example.kat.daggermvvmkotlinbasic.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.kat.daggermvvmkotlinbasic.repository.Repository
import javax.inject.Inject

class MyViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var resultdata = MutableLiveData<String>()

    fun getDataViewmodel(): String {
        val mydaggername = repository.getData()
        return mydaggername
    }

    fun callLiveData() {
        repository.getMyMutableData()
    }

    fun getMyLiveData(): MutableLiveData<String> {
        resultdata = repository.getMyLiveData()
        return resultdata
    }
}