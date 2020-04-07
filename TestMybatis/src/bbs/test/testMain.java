package bbs.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bbs.dao.NewsDao;
import bbs.dao.UserDao;
import bbs.model.Users;
/*
 * 应用升级
 * 1.增加属性配置文件jdbc.properties
 *2. 增加别名配置<typeAliases></typeAliases> 
 *3.当数据库中表的字段名与属性名不一致
 *
 *一级缓存
 *每一个 SqlSession 的内部都会有一个一级缓存对象
 *是指在同一个sqlSession中，执行相同的查询SQL，第一次会查询数据库，并将结果写入练存中；第二次直接从颈存中请取。
如果两次查询中，发生了增、删、改操作，则sqlsession会清空缓存。
作用地是同一个sqlsession
mybatis自动开启一级换存
 */
public class testMain {
public static void main(String[] args) throws FileNotFoundException {
	//获取数据库链接
	String path="src/mybatis-config.xml";
	
	InputStream inputStream=new FileInputStream(new File(path));
	SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
	
	SqlSession session=factory.openSession();//获取数据库连接的session
	//Users user=	session.selectOne("UserDao.getUserById", 1);
	//System.out.println(user);
	/*Users user1=	session.selectOne("UserDao.getUserById1", 2);
	System.out.println(user1);*/
	//  
	//获取映射器
	
	/*UserDao uDao=session.getMapper(UserDao.class);
	System.out.println(uDao.getAllUser());
	Users u=new Users();
	u.setAccount("wang");
	u.setName("wang");
	u.setPassword("123");
	uDao.addUser(u);
	session.commit();*/
	//NewsDao nDao= session.getMapper(NewsDao.class);
	//System.out.println(nDao.getNewsByTitle("意甲"));
	
//	Map<String, Object> map=new HashMap<String, Object>();
//	map.put("userid",null);
//	map.put("title", "意大利");
//	System.out.println(nDao.getNewsByUserdAndTitle(map));
	UserDao uDao=session.getMapper(UserDao.class);
	Users u=new Users();
	u.setId(5);
	u.setName("stevenzhang");
	u.setPassword("1908");
	uDao.updatUser(u);
	session.commit();
}
}
