private fun main() {
    /*
    如果lambda表达式只有一个参数,那么在调用该lambda表达式时,可以不指定它的参数名字.在lambda函数体内用it来代表这个参数.
    如果lambda表达式有多个参数,那么在调用该lambda表达式时,必须指定每一个参数的名字.
     */

    test1(5) { println("test1 没有it") }
    //引用
    test1(5,::test0)
    println("------------------------------")


    test2(6) { println("test2 it=$it") }
    test2(6,::test00)
    println("------------------------------")


    test3(3, 2) { println("test3 it=$it") }
    test3(22,33){a -> println("test3 a=$a 有a就没有it了")}
    println("------------------------------")

    test4(22,33){a,b ->
        println("test4 a=$a b=$b 没有it")
    }
    test4(22,33){a,b ->
        println("test4 a=$a b=$b 没有it a-b=${a-b}")
    }
    test4(22,33){_,b ->
        println("test4 省略a,只有b=$b 没有it")
    }
    //如果lambda表达式有两个及以上参数,那么即使lambda表达式的全部的参数都用不到,也不能省略"_,_ -> "
    test4(3,4){ _,_ ->
        println("test4 省略a和b 没有it")
    }
    //下面这样写是错误的.如果lambda表达式有两个及以上参数,那么任一参数都要用合法字符串或者_来表示,即使全都用不到也要用相应个数个_代替,
//    test4(3,4){ println("test4")}
    test4(1,2,::test000)
    println("------------------------------")

    test5 { println("test5 it=$it") }
    test5 { a -> println("test5 it=$a") }
    //lambda表达式只有一个参数,如果使用" _ -> 函数体 "这种方式来省略的话, 那么"_ ->"是多余的,应该去掉
    test5 { _ -> println("test5") }


}


private fun test0(){println("test0")}
private fun test00(x:Int){println("test00")}
private fun test000(x:Int,y:Int){println("test000 x+y=${x+y}")}

private fun test1(x: Int, action: () -> Unit) {
    action()
}

private fun test2(x: Int, action: (Int) -> Unit) {
    action(x)
}

private fun test3(x: Int, y: Int, action: (Int) -> Unit) {
    action(x)
}

private fun test4(x: Int, y: Int, action: (Int, Int) -> Unit) {
    action(x, y)
}

private fun test5(action: (Int) -> Unit){action(666)}
