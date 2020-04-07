package s.daoimpl;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;


import s.util.JdbcUtil2;
import s.dao.hotelDao;
import s.model.hotel;

 public class hotelDaoImpl implements hotelDao{
	QueryRunner runner=new QueryRunner(JdbcUtil2.getDataSource());
	
	public List<hotel> queryAllhotel() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="select  * from hotel limit 5";
		return runner.query(sql, new BeanListHandler<>(hotel.class)); 
	}

	@Override
	public List<hotel> getHotelByAeraAndComments() throws SQLException {
		// TODO Auto-generated method stub
		//���ݵ������飬��ѯ���������
String sql ="SELECT *,MAX(comments) from hotel GROUP BY nei_group ";
		return runner.query(sql, new BeanListHandler<>(hotel.class));
	}

	@Override
	public List<Map<String, Object>>  getHotelByAeraAndPrice() throws SQLException {
		// ���ݵ������飬��ѯ�۸���ߵ�
		String sql ="select nei_group,name,MAX(price) from hotel GROUP by nei_group ";
		return runner.query(sql, new MapListHandler());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>>  getHotelnumBytype() throws SQLException {
		// TODO Auto-generated method stub
		
	String sql ="select    room_type,COUNT(name) from hotel GROUP by room_type";
	 return runner.query(sql, new MapListHandler());
	}

	@Override
	public List<hotel> queryAllhotelMap() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="SELECT  `name`,longitude,latitude from hotel WHERE ava_365>300 and nums>5 AND reviews_per_month>0.5";
		return runner.query(sql, new BeanListHandler<>(hotel.class)); 
	}

	
	}

	
