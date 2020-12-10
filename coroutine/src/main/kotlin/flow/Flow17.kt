package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
buffer的主要作用在于对发射的缓冲，减少等待时间。
buffer与flowOn之间存在一定的关系:
实际上，flowOn运算符本质上在遇到需要改变coroutineDispatcher时也会使用同样的缓冲机制，只不过该示例并没有改变执行上下文而已。

 */

private fun myMethod(): Flow<Int> = flow {
    (1..4).forEach {
        println("before delay $it")
        delay(2000)
        println("emit $it")
        emit(it)
    }
}

private fun main() = runBlocking {
    val time= measureTimeMillis {
        myMethod().buffer().collect {
            delay(4000)
            println(it)
        }
    }

    println(time)
}
