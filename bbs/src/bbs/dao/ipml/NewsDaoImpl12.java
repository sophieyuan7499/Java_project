package bbs.dao.ipml;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bbs.dao.NewsDao;
import bbs.model.news;
import bbs.util.JdbcUtil2;

public class NewsDaoImpl12 implements NewsDao{
		QueryRunner runner=new QueryRunner(JdbcUtil2.getDataSource());
		@Override
		public List<news> getNews(int PageIndex, int pageSize) {
			String sql="select n.*,u.name 'userName' from news n inner join user u on n.userid = u.id order by date desc limit ?,?";//第一个是取数据库的起始数  第二个表示当前页数显示多少个
			Object[] params={pageSize*(PageIndex-1),pageSize};
			List<news> lst=new ArrayList<news>();
			try {
				lst=runner.query(sql, new BeanListHandler<news>(news.class), params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lst;
		}
		
		public boolean deleteByNewsId(int newsid) {
			boolean flag = false;
			String sql ="delete from News where id=? ";
			Object[] params={ newsid  };
			try {
				int count = runner.update(sql, params);
				flag = count>0?true:false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
		public boolean addNews(news a ){
			// TODO Auto-generated method stub
			boolean flag = true;
			String sql = "insert into news(title,content,date,userid) values(?,?,?,?)";
			Object[] params = {a.getTitle(),a.getContent(),a.getDate(),a.getUserid()};
			try {
				int num = runner.update(sql, params);
				flag = num>0 ? true:false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}

		

		@Override
		public void deleteNews(int id) {
			// TODO Auto-generated method stub
			String sql="delete from news where id=?";		
			Object[] param= {id};
			try {
				runner.update(sql, param);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public List<news> getNewsByUserId(int userid,int pageIndex,int pageSize) {
			String sql="select n.*,u.name 'userName' from news n inner join user u on n.userid = u.id where userid = ? limit ?,?";//第一个是取数据库的起始数  第二个表示当前页数显示多少个
			Object[] params={userid,pageSize*(pageIndex-1),pageSize};
			List<news> lst=new ArrayList<news>();
			try {
				lst=runner.query(sql, new BeanListHandler<news>(news.class), params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lst;
		}
		
		public boolean editNews(news new_0) {
			boolean flag=false;
			String sql="update news set title=?,content=? ,date=? where id=?";
			Object[] params={new_0.getTitle(),new_0.getContent(),new_0.getDate(),new_0.getId() };
			try {
				int count = runner.update(sql, params);
				flag = count>0?true:false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
		public List<news> getNewsByTitle(String title,int PageIndex, int pageSize){
			String sql = "select n.id, n.title,n.content,n.date,u.name 'userName' from news n  "
					+ "inner join user u on n.userid = u.id "
					+ " where title like ? limit ?,?";
			Object[] params = { "%" + title + "%" ,pageSize*(PageIndex-1),pageSize};
			List<news> lst = new ArrayList<news>();
			try {
				lst = runner.query(sql, new BeanListHandler<news>(news.class),
						params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lst;
		}

		public news getNewsByNewsId(int newsid) {
			String sql="select n.*,u.name 'userName' from news n inner join user u on n.userid = u.id where n.id = ?";
			Object[] params={newsid};
			news news_0=null;
			try {
				news_0 = runner.query(sql, new BeanHandler<news>(news.class), params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return news_0;
		}

		public int getCountAllNews() {
			String sql = "select count(*) from news n ";
			long l = 0l;
			try {
				l = runner.query(sql, new ScalarHandler<Long>());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (int) l;
		}

		@Override
		public int getCountByTitle(String title) {
			String sql = "select count(*) from news n where n.title like ?";
			long l = 0l;
			Object[] params={"%"+title+"%"};
			try {
				l = runner.query(sql, new ScalarHandler<Long>(),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (int) l;
		}

		
		/*public static void main(String[] args) {
			NewsDaoImpl12 n = new NewsDaoImpl12();
				//System.out.println(n.getNews(1, 2).get(0).getTitle());
				//System.out.println(n.getNewsByTitle("国际米兰夏季行", 1, 5));
			}*/
	}
