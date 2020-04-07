package  dao.impl;



import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.newsDao;
import model.User;
import  model.comment;
import  model.news;
import  util.JdbcUtil;


public class newDaoImpl implements newsDao {
	private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());

	@Override
	public void addnews(news n) {
		// TODO Auto-generated method stub
		String sql = "insert into news(userid,date,content,title) values(?,?,?,?)";
		Object[] params = { n.getUserid(),n.getDate2(),n.getContent(), n.getTitle() };
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletenews(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from news where id=?";
		Object[] params = { id };

		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 编辑帖子
	public void updatenews(String content, String title, int id) {
		// TODO Auto-generated method stub
		String sql = "update news set content=? ,title=? where id=?";
		Object[] params = { content, title, id };

		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 查询所有帖子
	public List<news> selectAllnews() {
		// TODO Auto-generated method stub
		String sql = "select *from news";
		List<news> list = new ArrayList<>();
		try {
			list = runner.query(sql, new BeanListHandler<news>(news.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	// 查询Id帖子
	public news selectidnews(int id) {
		// TODO Auto-generated method stub
		String sql = "select *from news where id=? ";
		Object[] params = { id };
		news news = new news();
		try {
			news = runner.query(sql, new BeanHandler<news>(news.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

	public List<news> selectueridnews(int userid) {
		// TODO Auto-generated method stub
		String sql = "select *from news where userid=? ";
		Object[] params = { userid };
		List<news> lst = new ArrayList<news>();
		try {
			lst= runner.query(sql, new BeanListHandler<news>(news.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}


	
	
	public  List<news> selectuertitlenews(String title){
		String sql="select * from news where title like ?";
		
		Object []params = { "%" + title + "%" };
		
		List<news> lst = new ArrayList<news>();
		
			try {
				  lst = runner.query(sql, new BeanListHandler<news>(news.class), params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return lst;
	}
	
	
	
	
	public static void main(String[] args) {
		newDaoImpl nnn = new newDaoImpl();
/*		news news = new news();                     //增
		news.setContent("dsad");
		news.setTitle("地下说俺不敢");
		news.setUserid(3);
	
		Date date = new Date();  					//加入时间
		Timestamp timeStamp = new Timestamp(date.getTime()); 
		news.setDate(timeStamp);
		newDaoImpl.addnews(news);*/
	//System.out.println(newDaoImpl.selectAllnews());	
		//nnn.deletenews(6);
		
		news n = new news(); 
	//System.out.print(nnn.selectidnews(1));
	
		//System.out.println(nnn.selectuertitlenews("1",10,2));
		//System.out.println(nnn.selectuertitlenews("1"));
	}

}
