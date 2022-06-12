package com.example.coroutines_koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.coroutines_koin.databinding.ActivityMainBinding
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    //1. Создаем scope там где планируем его использоввать
    //I0 - для пропостых лпераций, Main для UI, Uncofined -если нужно завершить операцию на томже потоке
    val scope = CoroutineScope(Dispatchers.IO)

    //создаем job для упорядочиния работы корутин
    var job: Job? = null


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            //создаем короутину
            job?.cancel()
            job = scope.launch {
                repeat(100) {
                    delay(1000)
                    println("VVV $it")
                }
            }
        }

    }

    suspend fun doSomthing(): String {
        delay(2000)

        return "Вовращаем строку"
    }

    //завершаем все короутины
    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }


}