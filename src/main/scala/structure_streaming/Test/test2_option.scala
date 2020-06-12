package src.main.scala.structure_streaming.Test

/**
 * HF
 * 2020-06-11 15:35
 */
object test2_option {
  def main(args: Array[String]): Unit = {
    val myMap: Map[String, String] = Map("key1" -> "value")
    val value1: Option[String] = myMap.get("key1")
    val value2: Option[String] = myMap.get("key2")
    println(myMap.get("key1"))
    println(value1) // Some("value1")
    println(value2) // None
    println("--------------")
    var map=Map[Int,String]()
    map+=(1->"one",2->"two")
    println(map.getOrElse(1,"default"))
    println(map.getOrElse(2,"default"))
    println(map.getOrElse(3,"default"))
    println(map.getOrElse(3,"这是本地1"))
    println(map.getOrElse(3,"这是仓库1"))

  }
}
