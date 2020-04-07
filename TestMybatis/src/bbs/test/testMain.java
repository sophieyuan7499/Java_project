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
 * Ӧ������
 * 1.�������������ļ�jdbc.properties
 *2. ���ӱ�������<typeAliases></typeAliases> 
 *3.�����ݿ��б���ֶ�������������һ��
 *
 *һ������
 *ÿһ�� SqlSession ���ڲ�������һ��һ���������
 *��ָ��ͬһ��sqlSession�У�ִ����ͬ�Ĳ�ѯSQL����һ�λ��ѯ���ݿ⣬�������д�������У��ڶ���ֱ�ӴӾ�������ȡ��
������β�ѯ�У�����������ɾ���Ĳ�������sqlsession����ջ��档
���õ���ͬһ��sqlsession
mybatis�Զ�����һ������
 */
public class testMain {
public static void main(String[] args) throws FileNotFoundException {
	//��ȡ���ݿ�����
	String path="src/mybatis-config.xml";
	
	InputStream inputStream=new FileInputStream(new File(path));
	SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
	
	SqlSession session=factory.openSession();//��ȡ���ݿ����ӵ�session
	//Users user=	session.selectOne("UserDao.getUserById", 1);
	//System.out.println(user);
	/*Users user1=	session.selectOne("UserDao.getUserById1", 2);
	System.out.println(user1);*/
	//  
	//��ȡӳ����
	
	/*UserDao uDao=session.getMapper(UserDao.class);
	System.out.println(uDao.getAllUser());
	Users u=new Users();
	u.setAccount("wang");
	u.setName("wang");
	u.setPassword("123");
	uDao.addUser(u);
	session.commit();*/
	//NewsDao nDao= session.getMapper(NewsDao.class);
	//System.out.println(nDao.getNewsByTitle("���"));
	
//	Map<String, Object> map=new HashMap<String, Object>();
//	map.put("userid",null);
//	map.put("title", "�����");
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
