package structure_streaming.day01


import java.sql.Timestamp

import org.apache.spark.sql.SparkSession


object window1 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("hf-windows")
      .getOrCreate()
    import spark.implicits._

    import org.apache.spark.sql.functions._
    val lines = spark.readStream
      .format("socket")
      .option("host","hadoop201")
      .option("port",9999)
      .option("includeTimestamp",true)
      .load()
      .as[(String,Timestamp)]
      .flatMap({
        case (words,ts)=> words.split("\\W+").map((_,ts))
      })
      .groupBy(window($"Timestamp","4 minutes","2 minutes"),$"String")
      .count()

    lines.writeStream.format("console")
      .outputMode("update")
      .option("truncate",false)
      .start()
      .awaitTermination()


  }
}
