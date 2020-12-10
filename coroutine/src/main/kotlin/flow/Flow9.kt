package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
transform
 */

private suspend fun myMethod(input: Int): String {
    delay(1000)
    return "output $input"
}

private fun main()= runBlocking {
    (1..10).asFlow().transform { input ->
        emit("my input: $input")
        emit(myMethod(input))
        emit("hello world")
    }.collect { println(it) }
}