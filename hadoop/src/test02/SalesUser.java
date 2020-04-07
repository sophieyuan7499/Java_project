package test02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javafx.scene.shape.Line;
import test02.test.Map;
import test02.test.Reduce;

public class SalesUser {
	static String INPUT_PATH="d://datas/sale_user1.csv";
	static String OUTPUT_PATH="hdfs://192.168.247.135:9000/test/test02/runoutput";
	 public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH"); //原时间格式
	 public static final SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd ");//现时间格式
	    
	
	public static String[] parse(String line){
		String user_id= parseuid(line);
		String item_id=parseitemid(line);
		String behavior_type=parsebehavior(line);
		String item_category=parseitem_category(line);
		String time=parseTime(line);
		String province=parseprovince(line);
		return new String[]{user_id,item_id,behavior_type,item_category,time,province};
	}


private static String parseuid(String line) {     
    String user_id =line.split(",")[0].trim();
    return user_id;
}

private static String parseitemid(String line) {     
    String item_id =line.split(",")[1].trim();
    return item_id;
}
private static String parsebehavior(String line) {     
    String behavior_type=line.split(",")[2].trim();
    return behavior_type;
}
private static String parseitem_category(String line) {     
    String item_category=line.split(",")[3].trim();
    return item_category;
}

private static Date parseDateFormat(String string){
    Date parse = null;
    try{
            parse = FORMAT.parse(string);//parse()方法，把String型的字符串转换成特定格式的date类型
    }catch (Exception e){
        e.printStackTrace();
    }
 return parse;
}
private static String parseTime(String line) {
    //time=日期String
    String time =line.split(",")[4].trim();
    Date date = parseDateFormat(time);
    return dateformat1.format(date);
}
public static String parseprovince(String line) {
	Random random=new Random();
	String citys[] = {"北京","广东","山东","江苏","河南","上海","河北","浙江","香港","山西","陕西","湖南","重庆","福建","天津","云南","四川","广西","安徽","海南","江西","湖北","山西","辽宁","内蒙古"};
	int randomInt = random.nextInt(1000000)%citys.length;
	String city= citys[randomInt] ;
	return city;
}

public static class Map extends
Mapper<LongWritable,Text,Text,NullWritable>{

public static Text word = new Text();
public void map(LongWritable key,Text value,Context context)
    throws IOException, InterruptedException{
String line = value.toString();
String arr[] = parse(line);
word.set(arr[0]+"\t"+arr[1]+"\t"+arr[2]+"\t"+arr[3]+"\t"+arr[4]+"\t"+arr[5]+"\t");
context.write(word,NullWritable.get());
}
}

public static class Reduce extends
Reducer<Text,NullWritable,Text,NullWritable>{
public void reduce(Text key, Iterable<NullWritable> values,Context context) 
    throws IOException, InterruptedException {
context.write(key, NullWritable.get());
} 
}

public static void main(String[] args) throws  Exception{
	Path inputpath=new Path(INPUT_PATH);
    Path outputpath=new Path(OUTPUT_PATH);
    Configuration conf=new Configuration();
    System.out.println("Start");
    Job job=Job.getInstance(conf);        
    job.setJarByClass(SalesUser.class);
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(NullWritable.class);
    FileInputFormat.addInputPaths(job, INPUT_PATH);
    FileOutputFormat.setOutputPath(job,outputpath);
    
    boolean flag = job.waitForCompletion(true);
    System.out.println(flag);
    System.exit(flag? 0 : 1);
}
}