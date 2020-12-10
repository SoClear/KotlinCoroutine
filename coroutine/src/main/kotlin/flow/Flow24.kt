package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/*
类似于catch运算符，onCompletion只会看到来自于Flow上游的异常，但是它看不到Flow下游的异常。

 */

private fun myMethod() =(1..10).asFlow()

@ExperimentalCoroutinesApi
private fun main() = runBlocking<Unit> {
    myMethod().onCompletion { cause -> println("Flow Completed with $cause") }
        .collect { value ->
            check(value <=1){ "Collected $value"}
            println(value)
        }
}

