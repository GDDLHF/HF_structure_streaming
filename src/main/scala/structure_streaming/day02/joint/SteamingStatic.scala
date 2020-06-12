package structure_streaming.day02.joint

import org.apache.spark.sql.SparkSession

/**
  * HF
  * 2020-01-25 18:02
  */
object SteamingStatic {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName("wocao")
      .getOrCreate()




  }
}
