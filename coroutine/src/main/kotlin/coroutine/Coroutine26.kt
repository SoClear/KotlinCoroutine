package coroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
private fun main():Unit= runBlocking{}
相当于
private fun main()= runBlocking<Unit> {}



使用JVM参数:-Dkotlinx.coroutines.debug 就会把协程的名字追加到线程名字后


 */

private fun main()= runBlocking<Unit> (CoroutineName("myCoroutine")){
    //下面的加号是运算符重载,实现了多个CoroutineContext合成一个.
    //这样既指定了协程分发器又指定了协程名字
    launch (Dispatchers.Default + CoroutineName("HelloWorld")){
        println("thread:${Thread.currentThread().name}")
    }
    println("thread:${Thread.currentThread().name}")
}

