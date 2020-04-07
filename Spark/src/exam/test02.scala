package exam

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD

object test02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ml-03").setMaster("local");
    val sc = new SparkContext(conf);
    
    val lines = sc.textFile("F://文档/作业/考试数据/wholesafe.csv", 1);
    val datas = lines.map(t=>{
       val arr = t.split(" ")
      
    })
    
     val Array(training,testing) = datas.randomSplit(Array(0.7,0.3), 11L)
  }
}