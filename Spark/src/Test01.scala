import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Test01 {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setAppName("Test01").setMaster("local[2]");
    val sc=new SparkContext(conf);
    val lines=sc.textFile("F://a大数据/练习/考试/1234.txt")
     val rdd1=lines.flatMap(t=>{t.split("	")}).map((_,1)).groupByKey().map(t=>{((t._1,t._2.reduce((a,b)=>(a+b))))})//不同ID
      rdd1.collect().foreach(println)
     val rdd2=lines.map(t=>{t.split("	")}).map(t=>(t(0),t(1))).groupByKey().map(t=>{t._2.size})
     //rdd2.collect().foreach(println)
  }
}