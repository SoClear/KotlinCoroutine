package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
Buffer缓冲
 */

private fun myMethod():Flow<Int> = flow {
    (1..4).forEach {
        delay(100)
        emit(it)
    }
}



private fun main() = runBlocking {
    val time= measureTimeMillis {
        myMethod().collect {
            delay(200)
            println(it)
        }
    }

    println(time)
}