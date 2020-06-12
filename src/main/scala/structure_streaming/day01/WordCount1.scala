package structure_streaming.day01

/**
  * HF
  * 2019-12-02 9:35
  */

import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.streaming.{DataStreamReader, DataStreamWriter, StreamingQuery, Trigger}
object WordCount1 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("wordCount1")
      .getOrCreate()

    import spark.implicits._

    val lines: DataFrame  = spark.readStream
      .format("socket")
      .option("host","hadoop201")
      .option("port",9999)
      .load()
     val stream = spark.readStream

    val wordCount = lines.as[String].flatMap(_.split(" ")).groupBy("value").count()

    val result: StreamingQuery = wordCount.writeStream
      .format("console")
      .outputMode("complete")
      .trigger(Trigger.ProcessingTime("2 seconds"))
      .start()
    result.awaitTermination()
    spark.stop()








  }

}
