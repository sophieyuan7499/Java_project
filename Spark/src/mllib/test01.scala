package mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
                              
  
object test01 {
def main(args: Array[String]): Unit = {
  val conf =new SparkConf().setAppName("test01").setMaster("local");
  val sc=new SparkContext(conf);

  val lines=sc.textFile("D://插件镜像/bigdata/spark-2.3.0-bin-hadoop2.7/data/mllib/ridge-data/lpsa.data", 1);
 lines.take(5).foreach(println);
  val datas = lines.map(t=>{
        val pos = t.split(",")
        pos(1).split(" ").map(_.toDouble);//转换为double类型的数组
         Vectors.dense(pos(1).split(" ").map(_.toDouble))//向量
         LabeledPoint(pos(0).toDouble,Vectors.dense(pos(1).split(" ").map(_.toDouble)))
         
    })

val model = LinearRegressionWithSGD.train(datas, 30);

  val res = datas.map(t=>{
      //对向量进行预测  t.features
      val prediction = model.predict(t.features)
      (t.label,prediction)
    })
    
    res.take(5).foreach(println)
    
    //求MSE   (真实值-预测值)的平方 和/点的个数
    
    val MSE = res.map({case(x,y) => math.pow((x-y),2)}).reduce(_+_)/res.count()
    
    println("MSE:"+MSE)
}
}