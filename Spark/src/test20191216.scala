import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object test20191216 {
def main(args: Array[String]): Unit = {
  val conf =new SparkConf().setAppName("test20191216").setMaster("local[2]");
    val sc=new SparkContext(conf);
    val lines=sc.textFile("F://a´óÊý¾Ý/Á·Ï°/2/b.txt");
    val rdd1=lines.map(t=>{t.split(" ")}).map(t=>(t(0),t(1).toDouble))
    
    val rdd3=rdd1.groupByKey().map(
x => {
val xx = x._1
val yy = x._2
(xx,yy.toList.sorted.reverse.take(3))
}
)
    val rdd2=rdd1.groupByKey().map(
x => {
val xx = x._1
val yy = x._2
(xx,yy.toList.sorted)
}
)
    
     rdd2.collect().foreach(println)
}
}