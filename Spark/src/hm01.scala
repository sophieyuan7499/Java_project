import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext


object hm01 {
  def main(args: Array[String]): Unit = {
     val sparkSession = SparkSession.builder.master("local").appName("example").getOrCreate()
     import sparkSession.implicits._
      val pattern = "[^a-zA-Z0-9-']";
     val lines = sparkSession.read.text("D://datas/spark/wordcount.txt").as[String];

  
     val words = lines.map(_.drop(2).replaceAll(pattern, " ")).flatMap(word => word.split(" "));
     val groupedWords = words.groupByKey(_.toLowerCase) ;
      //words.collect().foreach(println);
      val counts = groupedWords.count();
    counts.sort($"count(1)".desc).show(50)
  }
}