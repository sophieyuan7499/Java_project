package mllib

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD

object test03 {
  def main(args: Array[String]): Unit = {
     val conf =new SparkConf().setAppName("test03").setMaster("local");
     val sc=new SparkContext(conf);
     val raws = sc.textFile("F:/�ĵ�/��ҵ/������ҵ_191226190341_��溽�/������ҵ/ʵ������/train.tsv")
     val records = raws.map(line => line.split("\t"))
     //records.first().foreach(print)
     val data = records.map { r =>
val a = r.map(_.replaceAll("\"", ""))//"�滻Ϊ�ո�
//��ȡ���һ�еı�Ǳ����Լ���5�е���25�е���������
val label = a(r.size - 1).toInt
val features = a.slice(4, r.size - 1).map(d => if (d =="?") 0.0 else d.toDouble)
LabeledPoint(label, Vectors.dense(features))
}
     
val numData = data.count()
//data.take(2).foreach(println)

val model = LogisticRegressionWithSGD.train(data, 20)//��������10��

  val res = data.map(t=>{
      //����������Ԥ��  t.features
      val prediction = model.predict(t.features)
      (t.label,prediction)
    })

//res.take(5).foreach(println)
val totalCorrect = data.map { point => if (model.predict(point.features) == point.label) 1 else 0}.sum()
val accuracy =totalCorrect / numData
println(accuracy)
  }
}