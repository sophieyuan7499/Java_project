package bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bbs.dao.NewsDao;
import bbs.model.News;
import bbs.util.JdbcUtil;

public class NewsDaoImpl implements NewsDao{
	QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
	@Override
	public void addContent(News n) {
		// TODO Auto-generated method stub
		String sql="insert into news value(?,?,?,?,?)";
		Object[] params= {n.getId(),n.getTitle(),n.getContent(),n.getDate(),n.getUserid()};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void CancelCon(int id) {
		// TODO Auto-generated method stub
		String sql="delete from news where id=?";
		Object[] params= {id};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCon(int id, String content) {
		// TODO Auto-generated method stub
		String sql="update news set content=? where id=?";
		Object[] params= {content,id};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void allCont() {
		// TODO Auto-generated method stub
		String sql="select * from news";
		List<News> lst=new ArrayList<News>();
		try {
			lst=runner.query(sql, new BeanListHandler<News>(News.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lst);
		//return lst;
	}

	@Override
	public News getConById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from news where id=?";
		Object[] params= {id};
		News n=null;
		try {
			n=runner.query(sql,  new BeanHandler<News>(News.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<News> getConByUserID(int userid) {
		// TODO Auto-generated method stub
		String sql="select * from news where userid=?";
		Object[] params= {userid};
		List<News> lst=new ArrayList<News>();
		try {
			lst=runner.query(sql, new BeanListHandler<News>(News.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	public List<News> getNews(int PageIndex, int pageSize) {
		String sql="select * from news limit ?,?";//第一个是取数据库的起始数  第二个表示当前页数显示多少个
		Object[] params={pageSize*(PageIndex-1),pageSize};
		List<News> lst=new ArrayList<News>();
		try {
			lst=runner.query(sql, new BeanListHandler<News>(News.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}


	@Override
	public List<News> getNewsByTitle(String title,int PageIndex, int pageSize) {
		String sql = "select * from news where title like ? limit ?,?";
		Object[] params = { "%" + title + "%" ,pageSize*(PageIndex-1),pageSize};
		List<News> lst = new ArrayList<News>();
		try {
			lst = runner.query(sql, new BeanListHandler<News>(News.class),
					params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

//	 public static void main(String[] args) {
//	NewsDao nd=new NewsDaoImpl();
//		News n=new News();
////		System.out.println(nd.getNews(1, 10));
//		n.setId(3);
//		n.setTitle("hhh");
//		n.setContent("hhh");
//		n.getDate();
//		n.setUserid(1);
//		nd.addContent(n);
////		nd.addContent(n);
////		
////		System.out.println(nd.getNewsByTitle("123", 1, 5));
//		
//		
////		nd.CancelCon(1);
//		
////		nd.updateCon(1, "2345");
//		
////		nd.allCont();
//		
////		System.out.println(nd.getConById(1));
////		System.out.println(nd.getConByUserID(1));
//	}
}
