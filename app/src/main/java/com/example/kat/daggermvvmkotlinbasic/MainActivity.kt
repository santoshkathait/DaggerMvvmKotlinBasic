package com.example.kat.daggermvvmkotlinbasic

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kat.daggermvvmkotlinbasic.factory.MyViewModelFactory
import com.example.kat.daggermvvmkotlinbasic.viewmodels.MyViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMYComponent.create().inject(this)
        myViewModel = ViewModelProviders.of(this, factory).get(MyViewModel::class.java)

        // textval.text= myViewModel.getDataViewmodel()

        myViewModel.callLiveData()

        myViewModel.getMyLiveData().observe(this, Observer {
            textval.text = it
        })
    }
}

@Component(modules = [MYModule::class])
interface MYComponent {
    fun inject(activity: MainActivity)
}

@Module
abstract class MYModule {
    @Binds
    abstract fun bindviewmodelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory
}