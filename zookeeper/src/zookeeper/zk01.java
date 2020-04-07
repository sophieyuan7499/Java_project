package zookeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class zk01 {
	//连接ZooKeeper服务器的名称和端口号
	private static final String connectString="test1:2181,test2:2181,test3:2181";
	//设置延迟时间，超过2s自动断开连接
	private static final int sessionTimeout =2000;
public static void main(String[] args) throws IOException {
	
	//创建一个ZooKeeper客户端
	

	ZooKeeper zkClint=new ZooKeeper(connectString, sessionTimeout, new Watcher () {
/*
 * 定义一个匿名类的匿名对象
 * 相当于
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
		
		//一旦监听器被触发就执行
		@Override
		public void process(WatchedEvent arg0) {
			// TODO Auto-generated method stub
			//具体业务逻辑，可以不写，但必须有
		}
		
	});
	//创建节点的路径、保存的数据、权限、短暂或长久
	//zkClint.create(path, data, acl, createMode);
}
}
