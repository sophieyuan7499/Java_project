package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.regionserver.SplitTransactionFactory;
import org.apache.hadoop.hbase.thrift.generated.Hbase.Processor.getRow;
import org.apache.hadoop.hbase.util.Bytes;


/*
 * 1. 导入相关jar包
 * 2. 获取配置文件相关信息
 * conn=ConnectionFactory.createConnection(conf);
 * table=conn.getTable(TableName.valueOf("stu"));
 * 3. 对单独表进行增删改查需要先获取连接，创建表则不需要
 * 
 * 
 */
public class test01 {

	private static Configuration conf = null;
	private Connection conn;
	private Table table;
	static {
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "test1,test2,test3");
		conf.set("hbase.zookeeper.property.clientPort","2181");
		
	}

	
	
//创建表
	public void createTable() throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		HBaseAdmin admin=new HBaseAdmin(conf);
		//表名类
		TableName name=TableName.valueOf("test01");
		//表描述类，表名+列族
		HTableDescriptor desc=new HTableDescriptor(name);
		
		//列族描述类
		HColumnDescriptor famliy1=new HColumnDescriptor("info1");
		HColumnDescriptor famliy2=new HColumnDescriptor("info2");
		
		//把列族添加进表描述类中
		desc.addFamily(famliy1);
		desc.addFamily(famliy2);
		
		admin.createTable(desc);
	}
	
	
	
//新增+修改
	public void addData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		
		//插入集合
		List<Put> list=new ArrayList<Put>();
		Put p1=new Put(Bytes.toBytes("004"));//行键
		p1.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("coco"));
		p1.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("44"));
		
		Put p2=new Put(Bytes.toBytes("005"));//行键
		p2.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("emma"));
		p2.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("29"));
		
		Put p3=new Put(Bytes.toBytes("123"));//行键
		p3.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("catty"));
		p3.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("17"));
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		table.put(list);
		
		
		/*
		 * 
		 * 插入一条数据
		Put p=new Put(Bytes.toBytes("110"));//行键
		p.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("yuan"));
		p.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("21"));
		table.put(p);
		*/
		close();//调用关闭连接
				
	}
	
	
	
	//删除数据
	public void deleteData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		
		Delete d=new Delete(Bytes.toBytes("123"));
		d.addFamily(Bytes.toBytes("info1"));
		table.delete(d);
		close();
	}
	
	/*
	 * 查询：
	 * 单条查询
	 * 
	 * 扫描查询
	 * 
	 * 过滤器查询
	 * 
	 * */
	
	//单条查询
	public void getData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Get g=new Get(Bytes.toBytes("001"));
	
		//g.addFamily(family);//查询列族
		//g.addColumn(family, qualifier);查询单元格
		Result r=table.get(g);
		//byte[] family=Bytes.toBytes("info1");
		byte[] name=r.getValue(Bytes.toBytes("info1"), Bytes.toBytes("name"));
		byte[] age=r.getValue(Bytes.toBytes("info1"), Bytes.toBytes("age"));
		
		//System.out.println(name);//输出[B@39d9314d
		//System.out.println(age);
		//避免有的值为空出现空指针异常
		if(name !=null) {
		System.out.println(new String(name));//输出sophie
		//System.out.println(Bytes.toString(name));
		}
		if(age !=null) {
		System.out.println(new String(age));
		}
		//System.out.println(Bytes.toString(family));
	}

	
	
	//扫描查询
	public void scanData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Scan sc=new Scan();
		
	//设置从哪里开始扫描，到哪里结束
		//sc.setStartRow(Bytes.toBytes("002"));
		//sc.setStopRow(Bytes.toBytes("005"));
		ResultScanner res=table.getScanner(sc);
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
	
	
	
	//列值过滤器
	public void filter1() throws IOException{
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Scan scan =new Scan();
		
		SingleColumnValueFilter  filter =new SingleColumnValueFilter(Bytes.toBytes("info1"), 
				Bytes.toBytes("age"), CompareOp.GREATER_OR_EQUAL, Bytes.toBytes("20"));
		scan.setFilter(filter);
		ResultScanner res=table.getScanner(scan);
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
	
	
	
	//列名前缀过滤器
	public void filter2() throws IOException{
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Scan scan =new Scan();
		ColumnPrefixFilter  filter=new ColumnPrefixFilter(Bytes.toBytes("n"));//以n开通的列
		scan.setFilter(filter);
		ResultScanner res=table.getScanner(scan);
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
	
	
	
	//行键过滤器
	public void filter3() throws IOException{
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Scan scan =new Scan();
		
		//正则表达式
		RowFilter  filter=new RowFilter(CompareOp.EQUAL, new RegexStringComparator("^00"));//以00开头
		
		scan.setFilter(filter);
		ResultScanner res=table.getScanner(scan);
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
	//关闭连接方法
	public void close() throws IOException {
		table.close();
		conn.close();
	}
	
	public static void main(String[] args) {
		test01 t1=new test01();
		try {
			//t1.createTable();
			//t1.addData();
			//t1.deleteData();
			//t1.getData();
			//t1.scanData();
			//t1.filter1();
			//t1.filter2();
			t1.filter3();
		} catch (MasterNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
