package coroutine

import kotlinx.coroutines.*

private class Activity:CoroutineScope by CoroutineScope(Dispatchers.Default){
    fun destroy(){
        cancel()
    }

    fun doSomething(){
        repeat(8){
            launch {
                println("coroutine $it start")
                delay((it + 1) * 300L)
                println("coroutine $it finished")
            }
        }
    }
}

private fun main() = runBlocking {
    val activity = Activity()
    activity.doSomething()

    println("启动协程")
    delay(1300L)

    println("销毁Activity")
    activity.destroy()

    delay(9000)

}
