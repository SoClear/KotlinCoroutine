package coroutine

import kotlinx.coroutines.*

/*
ThreadLocal相关
 */

private val threadLocal = ThreadLocal<String>()

private fun main()= runBlocking <Unit>{
    threadLocal.set("hello")
    println("pre main,current thread:${Thread.currentThread()} ,thread local value : ${threadLocal.get()}")

    val job=launch(Dispatchers.Default +threadLocal.asContextElement(value = "world")) {
        println("launch start,current thread:${Thread.currentThread()} ,thread local value : ${threadLocal.get()}")
        yield()
        println("after yield,current thread:${Thread.currentThread()} ,thread local value : ${threadLocal.get()}")
    }

    job.join()
    println("post yield,current thread:${Thread.currentThread()} ,thread local value : ${threadLocal.get()}")
}