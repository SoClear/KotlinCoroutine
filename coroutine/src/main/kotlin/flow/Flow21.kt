package flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/*
Flow的完成
Kotlin提供了两种方式来实现Flow的完成
1。命令式
2。声明式

 */

private fun myMethod() = (1..10).asFlow()
//finally就是命令式
private fun main() = runBlocking {
    try {
        myMethod().collect { println(it) }
    }finally {
        println("finally")
    }
}