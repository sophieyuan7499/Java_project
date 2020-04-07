package bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bbs.dao.CommentDao;
import bbs.model.Comment;
import bbs.model.News;
import bbs.util.JdbcUtil;

public class CommentDaoImpl implements CommentDao{
	QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
	
	@Override
	public void addCom(Comment c) {
		// TODO Auto-generated method stub
		String sql="insert into comment value(?,?,?,?,?)";
		Object[] params= {c.getId(),c.getContent(),c.getDate(),c.getUserid(),c.getNewsid()};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Comment> getComByNewsid(int newsid) {
		// TODO Auto-generated method stub
		String sql="select * from comment where newsid=?";
		Object[] params= {newsid};
		List<Comment> lis=null;
		try {
			lis=runner.query(sql,  new BeanListHandler<Comment>(Comment.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lis;
	}
	
//	public static void main(String[] args) {
//		CommentDao cd=new CommentDaoImpl();
//		Comment c=new Comment();
//		
////		c.setId(1);
////		c.setContent("123");
////		c.setDate(null);
////		c.setUserid(1);
////		c.setNuwsid(1);
////		
////		cd.addCom(c);
//		
//		System.out.println(cd.getComByNewsid(1));
//	}
}
