package coroutine

import kotlinx.coroutines.*

/*
使用JVM参数:-Dkotlinx.coroutines.debug 就会把协程的名字追加到线程名字后

[Context1 @coroutine#1]
[Context2 @coroutine#1]
是两个不同的协程,线程Context1的协程coroutine#1 和 线程Context2的协程coroutine#1 是不同的.
 */

private fun log(logMessage:String)= println("[${Thread.currentThread().name}] $logMessage")

@ObsoleteCoroutinesApi
private fun main(){
    newSingleThreadContext("Context1").use {ctx1 ->
        newSingleThreadContext("Context2").use { ctx2 ->
            runBlocking(ctx1) {
                log("Started in Context1")

                withContext(ctx2){
                    log("Working in Context2")
                }

                log("Back to Context1")
            }
        }

    }
}

