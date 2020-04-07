import scala.util.matching.Regex

object tt {
   def main(args: Array[String]) {
      val sensitiveWord="大笨蛋"
    val title="断桥残雪是大  笨// 蛋"
    //正则对句子判断时,中间所有字符都替换为空字符
    val result=sensitiveWord.replaceAll("",".*").r.findFirstMatchIn(title)
    println(result.isEmpty)
    if(!result.isEmpty){
      println("title含有敏感词")
    }else{
      println("title不包含敏感词")
    }
    //包含敏感词,直接用其他符号将整句替代和谐
    val result2=sensitiveWord.replaceAll("",".*").r.replaceAllIn(title,"这句话包含敏感词,被和谐了")
    println(result2)
   }
}