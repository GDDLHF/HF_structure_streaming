//package structure_streaming.day01
//
//import java.sql.Timestamp
//
//import org.apache.spark.sql.SparkSession
//
///**
//  * HF
//  * 2019-12-19 15:01
//  */
//object Watermark1 {
//  def main(args: Array[String]): Unit = {
//    val spark = SparkSession
//      .builder()
//      .master("local[*]")
//      .appName("wordcontWatermark1")
//      .getOrCreate()
//    val line = spark.readStream
//      .format("socket")
//      .option("host","faladata01")
//      .option("port",9999)
//      .load()
//    val words = line.as[String]
//      .flatMap(line=>{
//        val split = line.split(",")
//        split(1).split(" ").map((_,Timestamp.valueOf(split(0))))
//      })
//      .toDF("word","timestamp")
//    import org.apache.spark.sql.functions._
//    words.withWatermark("timestamp","2 minutes")
//      .groupBy(
//        window($"timestame","10 minutes","2minutes"),$"word"
//      )
//      .count()
//      .writeStream.outputMode()
//
//
//
//  }
//}
