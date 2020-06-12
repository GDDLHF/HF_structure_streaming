package structure_streaming.day01

/**
  * HF
  * 2019-12-03 15:39
  */
import org.apache.spark.sql.SparkSession

object RateSource {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName("hf")
      .getOrCreate()

    val df = spark.readStream
      .format("rate")
      .option("rowsPerSecond",1000)
      .option("rampUpTime",1)
      .option("numPartition",3)
      .load()
    df.writeStream
      .format("console")
      .outputMode("update")
      .option("truncate",false)
      .start()
      .awaitTermination()



  }
}
