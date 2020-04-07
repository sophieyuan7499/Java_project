 package dao.impl;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.commentDao;
import model.comment;
import model.news;
import util.JdbcUtil;

public class commentDaoImpl implements commentDao{
	private QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());
	//��������
	public void addComment(comment c) {
		// TODO Auto-generated method stub
				String sql="insert into comment(userid,content,time,newsid) values(?,?,?,?)";
		Object [] params= {c.getUserid(),c.getContent(),c.getTime(),c.getNewsid()};
		
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//��ѯĳ�������е���������
	public comment selectALLcommect(int newsid) {
		// TODO Auto-generated method stub
		String sql="select *from comment where newsid=?";
		Object []params= {newsid};
		comment c=null;
		try {
			c = runner.query(sql, new BeanHandler<comment>(comment.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		commentDaoImpl commentDaoImpl=new commentDaoImpl();
		
		comment cc=new comment();
		
		//��
/*		cc.setContent("�����ޣ�������");
		cc.setNewsid(2);
		cc.setUserid(1);
		Date date = new Date();  					//����ʱ��
		Timestamp timeStamp = new Timestamp(date.getTime());
		cc.setTime(timeStamp);
		commentDaoImpl.addComment(cc);*/
		
		//System.out.println(commentDaoImpl.selectALLcommect(1));//�������Ӳ�
	}
}
