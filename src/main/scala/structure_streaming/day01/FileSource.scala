package structure_streaming.day01
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.Trigger


/**
  * HF
  * 2019-12-03 9:29
  */

object FileSource {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName("filesouce")
      .getOrCreate()

    val userSchema = StructType(StructField("name",StringType)::StructField("age",IntegerType)::StructField("sex",StringType)::Nil)
    val df = spark.readStream
      .format("csv")
      .schema(userSchema)
      .load("C:\\Users\\LEGION\\Desktop\\HF_ss")
      .groupBy("sex")
      .sum("age")

   df.writeStream
      .format("console")
      .outputMode("update")
      .trigger(Trigger.ProcessingTime(1000))
      .start()
      .awaitTermination()




  }
}
