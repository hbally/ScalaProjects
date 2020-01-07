import java.util.Date

/**
  * scala函数的几种形式
  * 函数传名调用(Call-by-Name)
  * 指定函数参数名
  * 函数 - 可变参数
  * 递归函数
  * 默认参数值
  * 高阶函数
  * 内嵌函数
  * 匿名函数
  * 偏应用函数
  * 函数柯里化(Function Currying)
  *
  */
object ScalaFunctions {

  //
  class Test {

    //类方法定义
    def m(x: Int) = x + 3

    //函数定义
    val f = (x: Int) => x + 3
  }

  //  传值调用（call-by-value）：先计算参数表达式的值，再应用到函数内部；
  //  传名调用（call-by-name）：将未计算的参数表达式直接应用到函数内部
  //  这就造成了一种现象，每次使用传名调用时，解释器都会计算一次表达式的值。

  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }

  /*
  call-by-name
   */
  def delayed(t: => Long) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }

  /**
    * call-by-value
    *
    * @param t
    * @return
    */
  def delayedByValue(t: Long) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }

  /**
    * 可变参数
    *
    * @param args
    */
  def printStrings(args: String*) = {
    var i: Int = 0;
    for (arg <- args) {
      println("Arg value[" + i + "] = " + arg)
      i = i + 1
    }
  }

  /*
    递归函数
   */
  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }

  /**
    * 默认参数
    *
    * @param a
    * @param b
    * @return
    */
  def addInt(a: Int = 5, b: Int = 7): Int = {
    var sum: Int = 0
    sum = a + b
    sum
  }

  /*
    高阶函数
   */
  // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
  def apply(f: Int => String, v: Int) = f(v)

  def layout[A](x: A) = "[" + x.toString() + "]"


  /**
    * 嵌套函数
    * @param i
    * @return
    */
  def factorial(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }

  /**
    * 匿名函数
    */
  var inc = (x:Int) => x+1
  //  等价于
  def add2 = new Function1[Int,Int]{
    def apply(x:Int):Int = x+1
  }


  def log(date: Date, message: String)  = {
    println(date + "----" + message)
  }

  /*
    函数柯里化(Currying)
    */

  def strcatOld(s1: String,s2: String) = {
    s1 + s2
  }

  def strcat(s1: String)(s2: String) = {
    s1 + s2
  }

  def main(args: Array[String]): Unit = {
    println("hello world ...")
    val test = new Test
    println("方法", test.m(2))
    println("函数", test.f(3))

    //函数传名调用和传值的区别
    //
    delayed(time)
    //
    println("*" * 10)
    delayedByValue(time())
    //
    printStrings("hello", "world", "body!")
    //
    println("递归调用" + "*" * 10)
    for (i <- 1 to 10)
      println(i + " 的阶乘为: = " + factorial(i))


    //高阶函数
    println( apply( layout, 10) )

    //嵌套函数
    println(factorial(23))
    //匿名函数
    println(inc(111))


    //偏应用函数
    val date = new Date
    log(date,"message ....1")
    log(date,"message ....2")
    //绑定第一个参数
    val logWithDateBound = log(date, _ : String)
    //
    logWithDateBound("message.....3")

    //函数柯里化
    val str1:String = "Hello, "
    val str2:String = "Scala!"
    println( "str1 + str2 = " +  strcat(str1)(str2) )

  }


}
