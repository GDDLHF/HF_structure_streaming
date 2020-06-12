package structure_streaming.day01

/**
  * HF
  * 2019-12-05 16:56
  */
import java.sql.Timestamp

import org.apache.spark.sql.SparkSession
object window1_HF {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("hf-windows")
      .getOrCreate()
    import spark.implicits._

    import org.apache.spark.sql.functions._
    val lines = spark.readStream
      .format("socket")
      .option("host","faladata03")
      .option("port",9999)
//      .option("includeTimestamp",true)
      .load()
      .as[String]
//      .toDF("word", "hbb")
      .writeStream.format("console")
      .outputMode("append")
      .option("truncate",false)
      .start()
      .awaitTermination()


  }
}
