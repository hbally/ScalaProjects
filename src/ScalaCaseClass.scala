/**
  * case class在实用应用中的其它用途
  * 某个类一旦被定义为case class，则编译器会自动生成该类的伴生对象，
  * 伴生对象中包括了apply方法及unapply方法，apply方法使得我们可以不需要new关键字就可以创建对象，
  * 而unapply方法，则使得可以方便地应用在模式匹配当中，
  * 另外编译器还自动地帮我们实现对应的toString、equals、copy等方法。
  * 在实际中，case class除了在模式匹配时能发挥其强大的威力之外，在进行其它应用时，
  * 也显示出了其强大的功能，下面给出case class在SparkSQL中的应用，旨在说明case class在实际应用中的重要地位。
  * ————————————————
  */
//抽象类Person
abstract class Person
//case class Student
case class Student(name:String,age:Int,studentNo:Int) extends Person
//case class Teacher
case class Teacher(name:String,age:Int,teacherNo:Int) extends Person
//case class Nobody
case class Nobody(name:String) extends Person

//
object ScalaCaseClass {

  //
  def main(args: Array[String]): Unit = {
    //case class 会自动生成apply方法，从而省去new操作
    val p:Person=Student("john",18,1024)
    //match case 匹配语法
    p  match {
      case Student(name,age,studentNo)=>println(name+":"+age+":"+studentNo)
      case Teacher(name,age,teacherNo)=>println(name+":"+age+":"+teacherNo)
      case Nobody(name)=>println(name)
    }
  }

}
