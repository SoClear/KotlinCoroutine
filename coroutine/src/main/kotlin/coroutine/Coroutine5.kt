package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
被suspend关键字所修饰的函数叫做挂起函数
挂起函数(suspending function)
挂起函数可以像普通函数一样用在协程当中，不过它的一个特性在于可以使用其他的挂起函数
重点:挂起函数只能用在协程或是另外一个挂起函数中


全局协程类似于守护线程(daemon thread)
使用GlobalScope启动的活动协程并不会保持进程的生命，他们就像是守护线程一样

 */

private fun main() {
    GlobalScope.launch {
        repeat(100){
            println(it)
            delay(200)
        }
    }
    Thread.sleep(2000)
}

