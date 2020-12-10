package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/*
flow的发射和收集不在同一个协程中时,应该用flowOn

下面会出错
 */

private fun myMethod():Flow<Int> = flow {
    withContext(Dispatchers.Default){
        (1..4).forEach {
            Thread.sleep(1000L)
            emit(it)
        }
    }
}

private fun main() = runBlocking {
    myMethod().collect { println(it) }
}

