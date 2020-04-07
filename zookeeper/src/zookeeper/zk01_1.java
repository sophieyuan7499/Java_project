package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class zk01_1 {
	//连接ZooKeeper服务器的名称和端口号
		private static final String connectString="test1:2181,test2:2181,test3:2181";
		//设置延迟时间，超过则自动断开连接
		private static final int sessionTimeout =30000;
		//如果此值小于zookeeper的创建时间，则当zookeeper还未来得及创建连接，会话时间已到，因此抛出异常认为该节点故障。
		
		private static ZooKeeper zkClint;
	
		public static void init() throws IOException {
			 zkClint=new ZooKeeper(connectString, sessionTimeout, new Watcher () {
						
						//一旦监听器被触发就执行
						@Override
						public void process(WatchedEvent arg0) {
							// TODO Auto-generated method stub
							//具体业务逻辑，可以不写，但必须有
						}
						
					});
		}
		
		//创建节点
		public static void createNode(String path,String content) throws KeeperException, InterruptedException {
			//创建节点的路径、保存的数据、权限、短暂或长久
			String str=zkClint.create(path, content.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(str);
		}
		
		
		//删除节点
		public static void deleteNode(String path) throws InterruptedException, KeeperException {
			zkClint.delete(path, -1);/*路径、版本，-1删除所有版本号*/
			
		}
		
		//判断节点是否存在
		public static void isExists(String path) throws KeeperException, InterruptedException {
			zkClint.exists(path, false);/*是否注册监听事件，没有不注册就写false，有则调用类所注册的监听器*/
			
		}
		
		//修改节点内容
		public static void setNode(String path,String content) throws KeeperException, InterruptedException {
			zkClint.setData(path, content.getBytes(), -1);/*路径、内容、版本号，-1更新所有版本*/
			
		}
		
		
		public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
			init();
			createNode("/eclipse", "hello zk");
		}
}
