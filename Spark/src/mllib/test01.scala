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

  val lines=sc.textFile("D://�������/bigdata/spark-2.3.0-bin-hadoop2.7/data/mllib/ridge-data/lpsa.data", 1);
 lines.take(5).foreach(println);
  val datas = lines.map(t=>{
        val pos = t.split(",")
        pos(1).split(" ").map(_.toDouble);//ת��Ϊdouble���͵�����
         Vectors.dense(pos(1).split(" ").map(_.toDouble))//����
         LabeledPoint(pos(0).toDouble,Vectors.dense(pos(1).split(" ").map(_.toDouble)))
         
    })

val model = LinearRegressionWithSGD.train(datas, 30);

  val res = datas.map(t=>{
      //����������Ԥ��  t.features
      val prediction = model.predict(t.features)
      (t.label,prediction)
    })
    
    res.take(5).foreach(println)
    
    //��MSE   (��ʵֵ-Ԥ��ֵ)��ƽ�� ��/��ĸ���
    
    val MSE = res.map({case(x,y) => math.pow((x-y),2)}).reduce(_+_)/res.count()
    
    println("MSE:"+MSE)
}
}