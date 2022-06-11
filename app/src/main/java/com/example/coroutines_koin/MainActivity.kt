package com.example.coroutines_koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    //1. Создаем scope там где планируем его использоввать
    //I0 - для пропостых лпераций, Main для UI, Uncofined -если нужно завершить операцию на томже потоке

    val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //создаем короутину
        scope.launch {
            doSomthing()
            withContext(Dispatchers.Main){
                Toast.makeText(this@MainActivity, "Toast!!!", Toast.LENGTH_SHORT).show()
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