package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.async.StrandedTaskReporting;

import  dao.CommentsDao;
import  model.Comments;
import  util.JdbcUtil;


public class CommentsDaoImpl implements CommentsDao{
	private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
	@Override
	public boolean addComments(Comments comm) {
		boolean flag = false;
		String sql="insert into comment(content,date,newsid,userid) values (?,?,?,?)";
		Object[] params = {comm.getContent(),comm.getDate(),comm.getNewsid(),comm.getUserid()};
		try {
			int count=runner.update(sql, params);
			flag = count>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
//根据新闻id查找评论
	@Override
	public List<Comments> getCommentsByNewsId(int newsid) {
		//String sql3="select *from comment where newsid=?";
		//String sql1="select coment.* , users.name from commetnt inner join user on comment.userid=user.id where newsid=?";
		String sql="select c.*,u.name 'username'  from comment c inner join user u on c.userid=u.id where newsid = ?";
		Object[] params={newsid};
		List<Comments> lst = new ArrayList<Comments>();
		try {
			lst = runner.query(sql, new BeanListHandler<Comments>(Comments.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public boolean deleteCommentsById(int id) {
		boolean flag = false;
		String sql = "delete from Comments where id = ?";
		Object[] params={id};
		try {
			int count = runner.update(sql, params);
			flag = count>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public void deleteCommentsByNewsId(int newsid) {
		
		String sql = "delete from Comments where newsid = ?";
		Object[] params={newsid};
		try {
			runner.update(sql, params);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static void main(String[] args) {
		//CommentsDao dao = new CommentsDaoImpl();
		//System.out.println(dao.getCommentsByNewsId(2).get(0).getUserName());
/*		Comments cs=new Comments();
		cs.setContent("add");
		cs.setDate(new Date());
		cs.setUserid(2);
		cs.setNewsid(1);
		dao.addComments(cs);*/
	//System.out.println(	dao.getCommentsByNewsId(2));
	}
}
