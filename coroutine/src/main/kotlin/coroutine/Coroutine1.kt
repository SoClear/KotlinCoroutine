package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val myJob=GlobalScope.launch {
        delay(1000)
        println("kotlin coroutine")
    }
    println("Hello ")
    //方式1:线程停2000ms
//    Thread.sleep(2000)

    //方式2:启动一个新的可以阻塞当前线程的协程
//    runBlocking {
//        delay(2000)
//    }
    //方式3:Suspends the coroutine until this job is complete.
    //挂起这个协程,直到这个工作完成
    myJob.join()
    println("World")
}