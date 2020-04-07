package exam

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row	  
import org.apache.spark.sql.SparkSession

object test01 {
  def main(args: Array[String]): Unit = {
     val conf =new SparkConf().setAppName("test01").setMaster("local[2]");
    val sc=new SparkContext(conf);
    val spark=SparkSession.builder().getOrCreate()
    
    val rdd1=sc.textFile("F://文档/作业/考试数据/a.txt").map(_.split(","))
    val list =StructType{
      List (
          StructField("name",StringType,true),
          StructField("sex",StringType,true),
          StructField("age",IntegerType,true)
      )
    }
     val rdd2=rdd1.map(t=>Row(t(0).toString(),t(1).toString(),t(2).toInt))
val df1=spark.createDataFrame(rdd2,list)
df1.createOrReplaceTempView("stu")
//df1.show()
//spark.sql("select *   from stu sort by age desc,name").show()
//spark.sql("select sum(case when sex='woman' then 1 else 0 end )    from stu").show()
//spark.sql("select sum(case when sex='man' then 1 else 0 end )    from stu").show()
spark.sql("select sex,avg(age) from stu  group by sex ").show()
  }
}