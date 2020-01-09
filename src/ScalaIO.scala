import java.io.{File, PrintWriter}

import scala.io.Source

object ScalaIO {

  class Handler {
    println("hello ....")
  }

  def main(args: Array[String]): Unit = {
    val writer = new PrintWriter(new File("test.txt" ))
    writer.write("菜鸟教程")
    writer.close()
    //
    Source.fromFile("test.txt" ).foreach{
      println
    }

    val handler = new Handler()
  }
}
