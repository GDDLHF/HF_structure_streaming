package structure_streaming.day01

/**
  * HF
  * 2019-12-04 18:43
  */
import org.apache.spark.sql.types.{LongType, StringType, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}
object TypeOpt {
  def main(args: Array[String]): Unit = {


    val spark: SparkSession = SparkSession
      .builder()
      .master("local[*]")
      .appName("BasicOperation")
      .getOrCreate()
    import spark.implicits._
    val peopleSchema: StructType = new StructType()
      .add("name", StringType)
      .add("age", LongType)
      .add("sex", StringType)
    val peopleDF: DataFrame = spark.readStream
      .schema(peopleSchema)
      .csv("C:\\Users\\LEGION\\Desktop\\HF_ss\\")  // 等价于: format("json").load(path)


//    val ds = peopleDF.as[People].filter(_.age > 20).select("name")  //这里能用select吗
   val ds = peopleDF.as[People].filter(_.age > 20).map(_.name)

    ds.writeStream
      .outputMode("update")
      .format("console")
      .start
      .awaitTermination()




  }

}

case class People(name: String, age: Long, sex: String)