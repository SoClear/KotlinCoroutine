package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

private fun main() = runBlocking {
    repeat(100000) {
        launch {
            delay(1000)
            println("A $it")
        }
    }
    println("Hello World")

//    repeat(100000){
//        thread {
//            Thread.sleep(1000)
//            println("A $it")
//        }
//    }
//    println("Hello World")
}