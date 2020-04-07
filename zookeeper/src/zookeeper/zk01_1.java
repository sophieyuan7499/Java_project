package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class zk01_1 {
	//����ZooKeeper�����������ƺͶ˿ں�
		private static final String connectString="test1:2181,test2:2181,test3:2181";
		//�����ӳ�ʱ�䣬�������Զ��Ͽ�����
		private static final int sessionTimeout =30000;
		//�����ֵС��zookeeper�Ĵ���ʱ�䣬��zookeeper��δ���ü��������ӣ��Ựʱ���ѵ�������׳��쳣��Ϊ�ýڵ���ϡ�
		
		private static ZooKeeper zkClint;
	
		public static void init() throws IOException {
			 zkClint=new ZooKeeper(connectString, sessionTimeout, new Watcher () {
						
						//һ����������������ִ��
						@Override
						public void process(WatchedEvent arg0) {
							// TODO Auto-generated method stub
							//����ҵ���߼������Բ�д����������
						}
						
					});
		}
		
		//�����ڵ�
		public static void createNode(String path,String content) throws KeeperException, InterruptedException {
			//�����ڵ��·������������ݡ�Ȩ�ޡ����ݻ򳤾�
			String str=zkClint.create(path, content.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(str);
		}
		
		
		//ɾ���ڵ�
		public static void deleteNode(String path) throws InterruptedException, KeeperException {
			zkClint.delete(path, -1);/*·�����汾��-1ɾ�����а汾��*/
			
		}
		
		//�жϽڵ��Ƿ����
		public static void isExists(String path) throws KeeperException, InterruptedException {
			zkClint.exists(path, false);/*�Ƿ�ע������¼���û�в�ע���дfalse�������������ע��ļ�����*/
			
		}
		
		//�޸Ľڵ�����
		public static void setNode(String path,String content) throws KeeperException, InterruptedException {
			zkClint.setData(path, content.getBytes(), -1);/*·�������ݡ��汾�ţ�-1�������а汾*/
			
		}
		
		
		public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
			init();
			createNode("/eclipse", "hello zk");
		}
}
