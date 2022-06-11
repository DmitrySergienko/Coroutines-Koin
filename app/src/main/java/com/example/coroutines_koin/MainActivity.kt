package com.example.coroutines_koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    //выводим(внедряем) нашу зависисимость
    private val repo: Repo by inject(named("RepoB"))
    private val someClass: SomeClass by inject()
    private val classWithConstructor: SomeClassWithConstructor by inject { parametersOf("Here should be String!!") }
    private val vm: MyViewModel by viewModel()
    private val someClassContext: SomeClassContext by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// 1) для получения объекта созданного единажды single
        //repo.print()

// 2) для получения зависимости (каждый раз новой через factory
        // getKoin().get<RepoA>().print()

// 3) для получения зависисмости сборка комплесного объекта
        // someClass.print()

// 4) для получения зависисмоти параметризованного класса, лучше обернуть в try/catch
        //так как параметр должен быть нужного типа

        /* try {
             classWithConstructor.emitData()
         } catch (e: Exception) {
             println("VVV $e")
         }*/

// 5)  для получения ViewModel
        //vm.getData()

// 6)  для получения context
        someClassContext.print()
    }


}