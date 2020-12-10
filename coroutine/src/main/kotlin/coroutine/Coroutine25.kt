package coroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
CoroutineName上下文元素可以让我们对协程进行命名，以便能够输出可读性较好的日志信息
使用JVM参数:-Dkotlinx.coroutines.debug 就会把协程的名字追加到线程名字后
 */

private fun log(logMessage:String)= println("[${Thread.currentThread().name}] $logMessage")

private fun main():Unit = runBlocking {
    log("hello")

    //这里的CoroutineName间接继承自CoroutineName
    val value1=async(CoroutineName("coroutine1")) {
        delay(800)
        log("coroutine1 log")
        30
    }

    val value2=async(CoroutineName("coroutine1")) {
        delay(1000)
        log("coroutine2 log")
        5
    }

    log("result is ${value1.await()*value2.await()}")
}