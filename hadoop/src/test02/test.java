package test02;

/**
 * MapReduce实验-数据清洗-阶段一
 * 高泽伟19.11.20
 * 
 */


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class test {
    
    static String INPUT_PATH="hdfs://192.168.57.128:9000/testhdfs1026/run/input/DataClean.txt";
    static String OUTPUT_PATH="hdfs://192.168.57.128:9000/testhdfs1026/run/output/DataClean";
    
    
    /*                
     * 数据格式：
     *                 Ip                    Date        Day|Traffic|Type|Id
     *             106.39.41.166,10/Nov/2016:00:01:02 +0800,10,54,video,8701
     */
    
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("d/MMM/yyyy:HH:mm:ss", Locale.ENGLISH); //原时间格式
    public static final SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//现时间格式
    
    //提取数据的函数  #########################################################################################
    //将一行数据清洗整合到一个字符串数组里 parse：解析
    //String line --> String[]
    public static String[] parse(String line){

        String ip = parseIP(line);
        String date = parseTime(line);
        String day = parseDay(line);
        String traffic = parseTraffic(line);
        String type = parseType(line);
        String id = parseId(line);
        return new String[]{ip,date,day,traffic,type,id};
    }
    
    //Ip
    private static String parseIP(String line) {     
        String ip =line.split(",")[0].trim();
        return ip;
    }
    
    //Date
    private static String parseTime(String line) {
        //time=日期String
        String time =line.split(",")[1].trim();
        //截取最后的" +0800"
        final int f = time.indexOf(" ");
        String time1 = time.substring(0, f);
        Date date = parseDateFormat(time1);
        return dateformat1.format(date);
    }
    //把String类型转换成Date类型
    private static Date parseDateFormat(String string){
        Date parse = null;
        try{
                parse = FORMAT.parse(string);//parse()方法，把String型的字符串转换成特定格式的date类型
        }catch (Exception e){
            e.printStackTrace();
        }
     return parse;
    }
    
    //Day
    private static String parseDay(String line) {     
        String day =line.split(",")[2].trim();
        return day;
    }
    
    //Traffic
    private static String parseTraffic(String line) {     
        String traffic = line.split(",")[3].trim();
        return traffic;
    }
    
    //Type
    private static String parseType(String line) {     
        String type = line.split(",")[4].trim();
        return type;
    }
    
    //Id
    private static String parseId(String line) {     
        String id =line.split(",")[5].trim();
        return id;
    }

    /*
     * Mapper 
     * 把需要的信息从原始日志中提取出来，根据提取出来的信息做精细化操作
     */
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
    
    
    
    public static void main(String[] args) throws Exception{
        Path inputpath=new Path(INPUT_PATH);
        Path outputpath=new Path(OUTPUT_PATH);
        Configuration conf=new Configuration();
        System.out.println("Start");
        Job job=Job.getInstance(conf);        
        job.setJarByClass(test.class);
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