package mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
                              

object teat {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setAppName("test01").setMaster("local");
  val sc=new SparkContext(conf);

  val lines=sc.textFile("D://插件镜像/bigdata/spark-2.3.0-bin-hadoop2.7/data/mllib/ridge-data/lpsa.data", 1);
  val datas = lines.map(t=>{
        val pos = t.split(",")
pos(1).split(" ").map(_.toDouble).foreach(print);//转换为double类型的数组         
    })
  }
}