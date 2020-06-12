package structure_streaming.day01

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
  * HF
  * 2019-12-03 8:24
  */
object test1 {
  def main(args: Array[String]): Unit = {
    val updatetime = DateTimeFormatter.ofPattern("yy/MM/dd/HH/mm/ss").format(LocalDateTime.now())
    println(updatetime)
    println("---------------")
    val time = System.currentTimeMillis()
    val s = "d"
    println(s)




  }

}
