package com.example.kat.daggermvvmkotlinbasic.repository

import android.arch.lifecycle.MutableLiveData
import javax.inject.Inject

class Repository @Inject constructor() {

    val mutableLiveData = MutableLiveData<String>()

    fun getData(): String {
        return "This is Dagger MVVM"
    }

    fun getMyMutableData() {
        mutableLiveData.value = "This is LiveData Dagger"
    }

    fun getMyLiveData(): MutableLiveData<String> {
        return mutableLiveData
    }
}