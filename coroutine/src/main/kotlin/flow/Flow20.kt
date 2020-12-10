package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/*
Flow Exception
 */

private fun myMethod1(): Flow<Int> = flow {
    (1..3).forEach {
        println("Emitting $it")
        emit(it)
    }
}

private fun myMethod2():Flow<String> = flow {
    (1..3).forEach {
        println("Emitting $it")
        emit(it)
    }
}.map {  value ->
    check(value <=1){ "Crash on $value"}
    "String $value"
}

private fun main() = runBlocking<Unit> {
    try {
        myMethod1().collect {
            println(it)
            check(it<1){
                "Collected $it"
            }
        }
    }catch (e:Throwable){
        println("Caught $e")
    }
    println("----------------------------------")

    try {
        myMethod2().collect { println(it) }
    }catch (e:Throwable){
        println("Caught $e")
    }
}


