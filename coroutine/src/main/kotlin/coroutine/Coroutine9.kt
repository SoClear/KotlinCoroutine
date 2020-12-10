package coroutine

import kotlinx.coroutines.*

/*
使用finally来关闭资源
join()与cancelAndJoin()都会等待所有清理动作(finally代码块)完成才会继续往下执行

 */

private fun main()= runBlocking {
    val myJob=launch {
        try {
            repeat(100){
                println("job: I am sleeping $it")
                delay(500)
            }
        }finally {
            println("执行了finally代码块")
            delay(10000)
            println("delay")
        }
    }
    delay(1300)
    println("hello world")
    myJob.cancelAndJoin()
    println("welcome")
}