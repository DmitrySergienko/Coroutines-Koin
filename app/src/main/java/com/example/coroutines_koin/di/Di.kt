package com.example.coroutines_koin.di

import com.example.coroutines_koin.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

//лучше имена выносить в публичные константы
const val REP_A = "RepoA"

object Di {
    val mainModule = module {
//---------------------------------------------------
        //зависимость создается в модуле и далее переиспользуется
        //single создает зависимость единажды
        //qualifier неоходим для разделяния по именам разных зависисмостей
        single<Repo>(qualifier = named(REP_A)) { RepoA() }
        single<Repo>(qualifier = named("RepoB")) { RepoB() }
//---------------------------------------------------
        //factory какждый раз создает новую зависимость
        //factory { RepoA() }
//---------------------------------------------------
        //сборка комплесного объекта например у нас есть класс с входящими параметрами
        single { SomeClass(repo = get(named("RepoA"))) }
//---------------------------------------------------
        //сборка класса с конструктором
        single{(data: String)-> SomeClassWithConstructor(data)}
//---------------------------------------------------
        // ViewModel
        viewModel { MyViewModel(repo = get(qualifier = named(REP_A))) }
//---------------------------------------------------
        //context
        single { SomeClassContext(context = androidApplication()) }
    }
}