package com.example.coroutines_koin

import androidx.lifecycle.ViewModel

class MyViewModel(val repo: Repo):ViewModel() {

    fun getData(){
        println("VVV ViewModel")
    }
}