package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
使用协程实现类似的效果

这是第二种方法:不阻塞主线程,且一次性返回结果
 */

private suspend fun myMethod():List<String> {
    //假装这里是很复杂的计算
    delay(1000)
    //然后返回结果
    return listOf("hello", "world", "hello world")
}

private fun main()= runBlocking<Unit> {
    myMethod().forEach { println(it) }
}

