package bbs.dao.ipml;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bbs.dao.ContentDao;
import bbs.model.content;
import bbs.model.news;
import bbs.util.JdbcUtil;


public class ContentDaoImpl implements ContentDao{
	private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
	@Override
	public boolean addContent(content comm) {
		boolean flag = false;
		String sql="insert into content values (?,?,?,?,?)";
		Object[] params = {null,comm.getContent(),comm.getDate(),comm.getNewsid(),comm.getUserid()};
		try {
			int count=runner.update(sql, params);
			flag = count>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<content> getContentByNewsId(int newsid) {
		String sql="select c.*,u.name'username' from content c inner join user u on c.userid=u.id where newsid = ?";
		Object[] params={newsid};
		List<content> lst = new ArrayList<content>();
		try {
			lst = runner.query(sql, new BeanListHandler<content>(content.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public boolean deleteContentById(int id) {
		boolean flag = false;
		String sql = "delete from content where id = ?";
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
	public void deleteContentByNewsId(int newsid) {
		
		String sql = "delete from content where newsid = ?";
		Object[] params={newsid};
		try {
			runner.update(sql, params);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	/*public static void main(String[] args) {
		ContentDao dao = new ContentDaoImpl();
		content content =new content();
		content.setContent("¼ÓÓÍ£¬À¶ºÚ");
		content.setDate(new Date());
		content.setNewsid(1);
		content.setUserid(7);
		dao.addContent(content);
	}*/

	
	
}
