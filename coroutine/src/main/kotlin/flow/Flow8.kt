package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
Flow的中间运算符
Flow的中间运算符的思想与Java Stream完全一致。
Flow与Sequence之间在中间运算符上的重要差别在于︰对于Flow来说，这些中间运算符内的代码块是可以调用挂起函数的。

 */

private suspend fun myMethod(input: Int): String {
    delay(1000)
    return "output $input"
}

private fun main() = runBlocking{
    (1..10).asFlow().filter { it >5 }.map { myMethod(it)}.collect { println(it) }
}