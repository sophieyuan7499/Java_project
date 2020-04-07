package test;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
/*
 * ¶à¸ö¹ýÂËÆ÷
 */
public class test02 {
	private static Configuration conf = null;
	private Connection conn;
	private Table table;
	static {
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "test1,test2,test3");
		conf.set("hbase.zookeeper.property.clientPort","2181");
		
	}
	
	public void filterlist() throws IOException {
		conn = ConnectionFactory.createConnection(conf);
		table = conn.getTable(TableName.valueOf("stu"));
		Scan s = new Scan();
		
		FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ALL); 
		
		RowFilter f1 = new RowFilter(CompareOp.EQUAL,new RegexStringComparator("^1"));
		SingleColumnValueFilter f2 = new SingleColumnValueFilter(Bytes.toBytes("info1"), 
				Bytes.toBytes("age"), CompareOp.GREATER, Bytes.toBytes("20"));		
	
		list.addFilter(f1);
		list.addFilter(f2);
		s.setFilter(list);
		ResultScanner res=table.getScanner(s);
		Iterator<Result> i = res.iterator();
		
		while(i.hasNext()) {
			Result r=i.next();
			byte[] name=r.getValue(Bytes.toBytes("info1"), Bytes.toBytes("name"));
			byte[] age=r.getValue(Bytes.toBytes("info1"), Bytes.toBytes("age"));
			System.out.println(Bytes.toString(r.getRow()) + "=");
			if(name !=null) {
				System.out.println(new String(name) );
				}
				if(age !=null) {
				System.out.println(new String(age));
				}
		}
		close();	
	}
	
	public void close() throws IOException {
		table.close();
		conn.close();
	}
	
	public static void main(String[] args) {
		test02 t2=new test02();
		try {
			t2.filterlist();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
