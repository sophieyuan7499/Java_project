package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class zk01 {
	//����ZooKeeper�����������ƺͶ˿ں�
	private static final String connectString="test1:2181,test2:2181,test3:2181";
	//�����ӳ�ʱ�䣬����2s�Զ��Ͽ�����
	private static final int sessionTimeout =2000;
public static void main(String[] args) throws IOException {
	
	//����һ��ZooKeeper�ͻ���
	

	ZooKeeper zkClint=new ZooKeeper(connectString, sessionTimeout, new Watcher () {
/*
 * ����һ�����������������
 * �൱��
 * public class zk01 {
 * public static void main(String[] args)
 * {ZooKeeper zkClint=new ZooKeeper(connectString, sessionTimeout, new AA());
 * }
 * }
 * 
 * public class AA implements Watcher{
 * public void process(WatchedEvent arg0) {}
 * 
 * }
 */
		
		//һ����������������ִ��
		@Override
		public void process(WatchedEvent arg0) {
			// TODO Auto-generated method stub
			//����ҵ���߼������Բ�д����������
		}
		
	});
	//�����ڵ��·������������ݡ�Ȩ�ޡ����ݻ򳤾�
	//zkClint.create(path, data, acl, createMode);
}
}
