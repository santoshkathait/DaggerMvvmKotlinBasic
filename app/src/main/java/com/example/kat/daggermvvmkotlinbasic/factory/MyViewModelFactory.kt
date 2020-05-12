package com.example.kat.daggermvvmkotlinbasic.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.kat.daggermvvmkotlinbasic.viewmodels.MyViewModel
import javax.inject.Inject
import javax.inject.Provider

class MyViewModelFactory @Inject constructor(private val myviewmodelprovider: Provider<MyViewModel>) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return myviewmodelprovider.get() as T
    }
}