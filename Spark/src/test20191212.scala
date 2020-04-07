import org.apache.spark.SparkConf
import org.apache.spark.SparkContext



object test20191212 {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setAppName("test20191212").setMaster("local[2]");
    val sc=new SparkContext(conf);
    val lines=sc.textFile("F://a������/��ϰ/��ϰ1/studentInfo.txt");
    val rdd1=lines.map(t=>{t.split(" ")}).map(t=>(t(2),t(3).toDouble))
    val rdd2=rdd1.groupByKey().map(t=>{(t._1,t._2.size)})//��Ů��������
    val rdd3=rdd1.groupByKey().map(t=>{(t._1,t._2.reduce((a,b)=>(a+b)))})//��Ů���ܷ���
     val rdd4=rdd1.groupByKey().map(t=>{(t._1,t._2.reduce((a,b)=>(a+b))/t._2.size)})
     
    rdd4.collect().foreach(println)
     
  }
}