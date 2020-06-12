package structure_streaming.day01

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
  * HF
  * 2019-12-13 14:40
  */
object test2 {
  def main(args: Array[String]): Unit = {
    val updatetime = DateTimeFormatter.ofPattern("yy年MM月dd日_HH:mm:ss").format(LocalDateTime.now())
printf(updatetime)

  }
}
