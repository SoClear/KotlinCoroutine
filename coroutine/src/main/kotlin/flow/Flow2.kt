package flow

/*
Sequence(序列)
如果在获取每一个元素时都需要执行一定的计算，这种计算是一种阻塞行为，将计算后的多个结果返回给调用端

关于序列的特点:
1．序列中的数据并非像集合那样一次性返回给调用端，而是计算完一个数据后就返回一个数据
2. 序列中的计算过程会使用主线程来进行，因此它会阻塞主线程的执行


这是第二种方法:阻塞主线程,且逐个返回结果
 */

private fun myMethod():Sequence<Int> = sequence {
    for (i in 100..105){
        //假装这里是很复杂的计算
        Thread.sleep(1000L)
        //生成数据
        yield(i)
    }
}

private fun main() {
    myMethod().forEach { println(it) }
}