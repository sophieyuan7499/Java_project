package homework1;

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
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
public class work1 {


	private static Configuration conf=null;
	private Connection conn;
	private Table table;
	static {
		
		conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum","test1,test2,test3");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
	
	}
	//�й�����
	public void filter1() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("test"));
		
		Scan s=new Scan();
		RowFilter filter = new RowFilter(CompareOp.EQUAL, new RegexStringComparator("3$"));
		s.setFilter(filter);
		
		ResultScanner res=table.getScanner(s);
		Iterator<Result> i=res.iterator();
		System.out.println("�����ȡrowkey��βΪ3����");
		while(i.hasNext()) {
			
			Result rs=i.next();
			byte[] name =rs.getValue(Bytes.toBytes("f1"), Bytes.toBytes(""));
			byte[] date =rs.getValue(Bytes.toBytes("f2"), Bytes.toBytes(""));
			byte[] type =rs.getValue(Bytes.toBytes("f3"), Bytes.toBytes(""));
			byte[] price =rs.getValue(Bytes.toBytes("f4"), Bytes.toBytes(""));
			byte[] send_addr =rs.getValue(Bytes.toBytes("f5"), Bytes.toBytes(""));
			byte[] accept_addr =rs.getValue(Bytes.toBytes("f6"), Bytes.toBytes(""));
			byte[] phone =rs.getValue(Bytes.toBytes("f7"), Bytes.toBytes(""));
			
			if(name != null) {
				
				System.out.print(Bytes.toString(name));
			}
		    if(date != null) {
		    	
		    	System.out.print(Bytes.toString(date));//Bytes.toString(age)�����int����ת��
		    }

		    if(type != null) {
				
				System.out.print(Bytes.toString(type));
			}

		    if(price != null) {
				
				System.out.print(Bytes.toString(price));
			}
			if(send_addr != null) {
				
				System.out.print(Bytes.toString(send_addr));//��null������������ָ���쳣
			}

			if(accept_addr != null) {
				
				System.out.print(Bytes.toString(accept_addr));//��null������������ָ���쳣
			}
			if(phone != null) {
				
				System.out.println(Bytes.toString(phone));//��null������������ָ���쳣
			}
		}
		close();
	}
	//����ֵ������
	public void filter2() throws IOException {
		conn=ConnectionFactory.createConnection(conf);
		table=conn.getTable(TableName.valueOf("test"));
		Scan s=new Scan();
		//���һ�������� where price>100
				SingleColumnValueFilter  filter = new SingleColumnValueFilter(Bytes.toBytes("f4"), 
						Bytes.toBytes(""), CompareOp.GREATER, Bytes.toBytes("100"));
	
				s.setFilter(filter);
				
				ResultScanner res=table.getScanner(s);
				Iterator<Result> i=res.iterator();
				System.out.println("��ȡ���Ѽ۸����100���û�:");
				while(i.hasNext()) {
					
					Result rs=i.next();
					byte[] name =rs.getValue(Bytes.toBytes("f1"), Bytes.toBytes(""));
					byte[] date =rs.getValue(Bytes.toBytes("f2"), Bytes.toBytes(""));
					byte[] type =rs.getValue(Bytes.toBytes("f3"), Bytes.toBytes(""));
					byte[] price =rs.getValue(Bytes.toBytes("f4"), Bytes.toBytes(""));
					byte[] send_addr =rs.getValue(Bytes.toBytes("f5"), Bytes.toBytes(""));
					byte[] accept_addr =rs.getValue(Bytes.toBytes("f6"), Bytes.toBytes(""));
					byte[] phone =rs.getValue(Bytes.toBytes("f7"), Bytes.toBytes(""));
					
					if(name != null) {			
						System.out.print(Bytes.toString(name));
					}
				    if(date != null) {
				    	System.out.print(Bytes.toString(date));
				    }
				    if(type != null) {
						System.out.print(Bytes.toString(type));
					}
				    if(price != null) {
						System.out.print(Bytes.toString(price));
					}
					if(send_addr != null) {
						System.out.print(Bytes.toString(send_addr));//��null������������ָ���쳣
					}
					if(accept_addr != null) {
						System.out.print(Bytes.toString(accept_addr));//��null������������ָ���쳣
					}
					if(phone != null) {
						System.out.println(Bytes.toString(phone));//��null������������ָ���쳣
					}
				}
				close();
	}
	//����ֵ������
		public void filter3() throws IOException {
			conn=ConnectionFactory.createConnection(conf);
			table=conn.getTable(TableName.valueOf("test"));
			        Scan s=new Scan();
					SingleColumnValueFilter  filter = new SingleColumnValueFilter(Bytes.toBytes("f1"), 
							Bytes.toBytes(""), CompareOp.EQUAL,Bytes.toBytes("������"));
		
					s.setFilter(filter);
					
					ResultScanner res=table.getScanner(s);
					Iterator<Result> i=res.iterator();
					System.out.println("��ȡ����Ϊ�����ε��û�����:");
					while(i.hasNext()) {
						
						Result rs=i.next();
						byte[] name =rs.getValue(Bytes.toBytes("f1"), Bytes.toBytes(""));
						byte[] date =rs.getValue(Bytes.toBytes("f2"), Bytes.toBytes(""));
						byte[] type =rs.getValue(Bytes.toBytes("f3"), Bytes.toBytes(""));
						byte[] price =rs.getValue(Bytes.toBytes("f4"), Bytes.toBytes(""));
						byte[] send_addr =rs.getValue(Bytes.toBytes("f5"), Bytes.toBytes(""));
						byte[] accept_addr =rs.getValue(Bytes.toBytes("f6"), Bytes.toBytes(""));
						byte[] phone =rs.getValue(Bytes.toBytes("f7"), Bytes.toBytes(""));
						
						if(name != null) {			
							System.out.print(Bytes.toString(name));
						}
					    if(date != null) {
					    	System.out.print(Bytes.toString(date));
					    }
					    if(type != null) {
							System.out.print(Bytes.toString(type));
						}
					    if(price != null) {
							System.out.print(Bytes.toString(price));
						}
						if(send_addr != null) {
							System.out.print(Bytes.toString(send_addr));
						}
						if(accept_addr != null) {
							System.out.print(Bytes.toString(accept_addr));
						}
						if(phone != null) {
							System.out.println(Bytes.toString(phone));
						}
					}
					close();
		}
public void close() throws IOException {
		
		table.close();
		conn.close();
	}
	public static void main(String[] args) {
	
		work1  t=new work1();
		try {
			//t.filter1();
		//t.filter2();
			t.filter3();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
