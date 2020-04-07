package singapore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD


object test01 {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setAppName("test01").setMaster("local");
     val sc=new SparkContext(conf);
     val raws = sc.textFile("D:/Êı¾İ¼¯/singapore-airbnb/data1.csv")
    val data = raws.map { r =>val m=r.split(" ")
     }
    data.take(1).foreach(println)
    
  }
}