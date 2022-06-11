package com.example.coroutines_koin

class SomeClassWithConstructor(private val data: String) {

    fun emitData(){
        println("VVV $data")
    }
}
