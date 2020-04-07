package hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class HdfsDAO {
	Configuration conf=new Configuration();
	static FileSystem fs=null;
	
	public  HdfsDAO() throws IOException  {
	 
	conf.set("fs.defaultFS", "hdfs://192.168.247.135:9000");
	}
	
	public void mkdir(String floder) throws IllegalArgumentException, IOException {
		
			fs=FileSystem.get(conf);
			fs.mkdirs(new Path(floder));
			 fs.close();
	
		
	}
	
	
	public void rmr(String floder) throws IOException {
		fs=FileSystem.get(conf);
		fs.delete(new Path(floder));
		 fs.close();
	}
	
	public void	ls(String floder) throws IOException {
		//1����ȡ�ļ�ϵͳ����
		fs=FileSystem.get(conf);
		 //2����ȡ��Ŀ¼�µ��ļ�����---FileStatus��ȡ�ļ���Ԫ����
		FileStatus[] list=fs.listStatus(new Path(floder));
       
        //3��ѭ������·����������
        for(FileStatus ele:list){
            System.out.println(ele.getPath().getName());
        }
        fs.close();
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	HdfsDAO hdfsDAO =new HdfsDAO();
	//hdfsDAO.mkdir("/test/hdfs2/");
	//hdfsDAO.mkdir("/test/hdfs3/");
	//hdfsDAO.rmr("/test/hdfs3/");
	hdfsDAO.ls("/test/hdfs1/");
	}

}
