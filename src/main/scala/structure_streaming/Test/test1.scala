package src.main.scala.structure_streaming.Test

import scala.util.control.Breaks

/**
 * HF
 * 2020-06-11 11:46
 */
object test1 {
  def main(args: Array[String]): Unit = {


    //Breaks.breakable(    //Breaks.break()   !lessThanMaxTime ||
    var dayLengthTmp = 99
    var result = List[String]()
    val  temperatures = List[Int](73, 74, 75, 71, 69, 72, 76, 73);println(temperatures)
      for ( i <- 0 until temperatures.length ) {
        Breaks.breakable(
          for ( j <- i+1 until temperatures.length ) {
            if (temperatures(j) > temperatures(i)){
              dayLengthTmp =  j - i
              result :+= (temperatures(i).toString +"-" + dayLengthTmp).toString
              Breaks.break()
            }
            result :+= (temperatures(i).toString +"-" + dayLengthTmp).toString
          }
        )


      }
println(result)



  }
}
