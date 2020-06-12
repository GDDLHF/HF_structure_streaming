package structure_streaming.day01

/**
  * HF
  * 2019-12-03 16:09
  */
import org.apache.spark.sql.types.{LongType, StringType, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}
object UnTypeOpt {

  def main(args: Array[String]): Unit = {

  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("hf")
    .getOrCreate()

    val peopleSchema = new StructType()
      .add("name",StringType)
      .add("age",LongType)
      .add("sex",StringType)

    val peopleDF = spark.readStream
      .schema(peopleSchema)
      .json("C:\\Users\\LEGION\\Desktop\\HF_ss\\")

val df = peopleDF.select("name","age","sex").groupBy("sex").sum("age")
//val df = peopleDF.map(_.name)
    df.writeStream
      .outputMode("complete")
      .format("console")
      .start()
      .awaitTermination()










  }
}
