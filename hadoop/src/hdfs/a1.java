package hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class a1 {
public static void main(String[] args) throws IOException {
	Configuration conf=new Configuration();
	conf.set("fs.defaultFS", "hdfs://192.168.247.135:9000");
	FileSystem fs=FileSystem.get(conf);
	
	//�����ļ���
	//boolean f=fs.mkdirs(new Path("/test/hdfs2"));
	//System.out.println(f);
	//ɾ���ļ���
//	fs.delete(new Path("/test/hdfs2"),true);
	
	//�����ļ���д��
//	FSDataOutputStream fos=fs.create(new Path("/test/hdfs1/b.txt"));
//	byte[] b="hello bigdata".getBytes();
//	fos.write(b, 0, b.length);
	
//�ϴ��ļ�
	fs.copyFromLocalFile(new Path("D:\\a.txt"),new Path("/test/hdfs1/"));
	
	
	
	fs.close();
}
}
