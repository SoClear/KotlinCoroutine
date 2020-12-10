package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
Flow完成的声明式方法
对于声明式方式来说，Plow提供了一个名为onCompletion中间操作，该操作会在Flow完成收集后得到调用

 */

private fun myMethod() =(1..10).asFlow()
//Flow完成的声明式方法
@ExperimentalCoroutinesApi
private fun main() = runBlocking<Unit> {
    myMethod().onCompletion { println("on Completion") }.collect { println(it) }
}