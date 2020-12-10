package coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/*
使用JVM参数:-Dkotlinx.coroutines.debug 就会把协程的名字追加到线程名字后

 */

private fun log(logMessage:String)= println("[${Thread.currentThread().name}] $logMessage")

private fun main():Unit = runBlocking {
    val a=async {
        log("hello world")
        10
    }

    val b=async {
        log("welcome")
        20
    }

    log("The result is ${a.await()*b.await()}")
}