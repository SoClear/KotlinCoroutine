package coroutine

import kotlinx.coroutines.*

/*
协程的取消与超时
 */

private fun main()= runBlocking {
    val myJob=GlobalScope.launch {
        repeat(200){
            println("hello :$it")
            delay(500)
        }
    }

    delay(1100)
    println("hello world")

//    myJob.cancel()
//    myJob.join()

    myJob.cancelAndJoin()
    println("welcome")
}

