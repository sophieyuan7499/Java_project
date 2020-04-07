package SQL
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.types._
import org.apache.spark.sql.Row	  
import org.apache.spark.sql.SparkSession

object sparkSQL01{
 def main(args: Array[String]): Unit = {
   val conf =new SparkConf().setAppName("sparkSQL01").setMaster("local[2]");
    val sc=new SparkContext(conf);
    val spark=SparkSession.builder().getOrCreate()
    
    val rdd1=sc.textFile("F://�ĵ�/��ҵ/������ҵ/ʵ������/ʵ������.txt").map(_.split(" "))  
   val schema=StructType(
       List(
           StructField("id",IntegerType,true),
           StructField("name",StringType,true),
           StructField("sex",StringType,true),
           StructField("score",DoubleType,true)
       )   
   )
  
 val rdd2=rdd1.map(t=>Row(t(0).toInt,t(1).toString(),t(2).toString(),t(3).toDouble))
val df1=spark.createDataFrame(rdd2,schema)
df1.createOrReplaceTempView("stu")
//df1.show()
//spark.sql("select sum(case when sex='F' then 1 else 0 end )    from stu").show()//Ů������
//spark.sql("select sum(case when sex='M' then 1 else 0 end )  from stu").show()//��������
//spark.sql("select sex,avg(score) from stu  group by sex ").show()//��Ů��ƽ����
spark.sql("select *   from stu sort by score desc").show()//���ɼ���������
 }
}