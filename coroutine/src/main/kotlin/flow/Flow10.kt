package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/*
限定数量的中间操作
 */

private fun myNumbers1(): Flow<Int> = flow{
    emit(1)
    emit(2)
    println("hello world")
    emit(3)
}

private fun myNumbers2(): Flow<Int> = flow{
    try {
        emit(1)
        emit(2)
        println("hello world")
        emit(3)
    }catch (e:Exception){
        println(e)
    }finally {
        println("finally")
    }
}

private fun main()= runBlocking {
    myNumbers1().take(2).collect { println(it) }
    println("---------------------")
    myNumbers2().take(2).collect { println(it) }
}