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
 * 1. �������jar��
 * 2. ��ȡ�����ļ������Ϣ
 * conn=ConnectionFactory.createConnection(conf);
 * table=conn.getTable(TableName.valueOf("stu"));
 * 3. �Ե����������ɾ�Ĳ���Ҫ�Ȼ�ȡ���ӣ�����������Ҫ
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

	
	
//������
	public void createTable() throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		HBaseAdmin admin=new HBaseAdmin(conf);
		//������
		TableName name=TableName.valueOf("test01");
		//�������࣬����+����
		HTableDescriptor desc=new HTableDescriptor(name);
		
		//����������
		HColumnDescriptor famliy1=new HColumnDescriptor("info1");
		HColumnDescriptor famliy2=new HColumnDescriptor("info2");
		
		//��������ӽ�����������
		desc.addFamily(famliy1);
		desc.addFamily(famliy2);
		
		admin.createTable(desc);
	}
	
	
	
//����+�޸�
	public void addData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		
		//���뼯��
		List<Put> list=new ArrayList<Put>();
		Put p1=new Put(Bytes.toBytes("004"));//�м�
		p1.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("coco"));
		p1.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("44"));
		
		Put p2=new Put(Bytes.toBytes("005"));//�м�
		p2.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("emma"));
		p2.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("29"));
		
		Put p3=new Put(Bytes.toBytes("123"));//�м�
		p3.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("catty"));
		p3.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("17"));
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		table.put(list);
		
		
		/*
		 * 
		 * ����һ������
		Put p=new Put(Bytes.toBytes("110"));//�м�
		p.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("name"), Bytes.toBytes("yuan"));
		p.addColumn(Bytes.toBytes("info1"), Bytes.toBytes("age"), Bytes.toBytes("21"));
		table.put(p);
		*/
		close();//���ùر�����
				
	}
	
	
	
	//ɾ������
	public void deleteData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		
		Delete d=new Delete(Bytes.toBytes("123"));
		d.addFamily(Bytes.toBytes("info1"));
		table.delete(d);
		close();
	}
	
	/*
	 * ��ѯ��
	 * ������ѯ
	 * 
	 * ɨ���ѯ
	 * 
	 * ��������ѯ
	 * 
	 * */
	
	//������ѯ
	public void getData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Get g=new Get(Bytes.toBytes("001"));
	
		//g.addFamily(family);//��ѯ����
		//g.addColumn(family, qualifier);��ѯ��Ԫ��
		Result r=table.get(g);
		//byte[] family=Bytes.toBytes("info1");
		byte[] name=r.getValue(Bytes.toBytes("info1"), Bytes.toBytes("name"));
		byte[] age=r.getValue(Bytes.toBytes("info1"), Bytes.toBytes("age"));
		
		//System.out.println(name);//���[B@39d9314d
		//System.out.println(age);
		//�����е�ֵΪ�ճ��ֿ�ָ���쳣
		if(name !=null) {
		System.out.println(new String(name));//���sophie
		//System.out.println(Bytes.toString(name));
		}
		if(age !=null) {
		System.out.println(new String(age));
		}
		//System.out.println(Bytes.toString(family));
	}

	
	
	//ɨ���ѯ
	public void scanData() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Scan sc=new Scan();
		
	//���ô����￪ʼɨ�裬���������
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
	
	
	
	//��ֵ������
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
	
	
	
	//����ǰ׺������
	public void filter2() throws IOException{
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Scan scan =new Scan();
		ColumnPrefixFilter  filter=new ColumnPrefixFilter(Bytes.toBytes("n"));//��n��ͨ����
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
	
	
	
	//�м�������
	public void filter3() throws IOException{
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("stu"));
		Scan scan =new Scan();
		
		//������ʽ
		RowFilter  filter=new RowFilter(CompareOp.EQUAL, new RegexStringComparator("^00"));//��00��ͷ
		
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
	//�ر����ӷ���
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
