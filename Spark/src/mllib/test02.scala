package mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.clustering.KMeans


object test02 {
def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setAppName("test03").setMaster("local");
    val sc=new SparkContext(conf);
    val rdd1=sc.textFile("D:/插件镜像/bigdata/spark-2.3.0-bin-hadoop2.7/data/mllib/kmeans_data.txt", 1)
    val rdds=rdd1.map(t=>{ Vectors.dense(t.split(" ").map(_.toDouble))})
    
    for(i<-2 to 20){
      val model=KMeans.train(rdds, i, 20)
      val cost=model.computeCost(rdds)
      println("i="+i+"，误差平方和："+cost)
    }
    
    
}  
}