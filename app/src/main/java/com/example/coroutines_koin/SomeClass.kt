package com.example.coroutines_koin

class SomeClass(private val repo: Repo) {
    fun print() {
        println("VVV ${repo.print()}")
    }
}