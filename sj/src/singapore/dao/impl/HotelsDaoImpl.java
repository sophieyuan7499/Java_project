package singapore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import singapore.util.JdbcUtil;
import singapore.dao.HotelsDao;
import singapore.model.hotels;

public class HotelsDaoImpl implements HotelsDao{
	private QueryRunner run = new QueryRunner(JdbcUtil.getDataSource());
	@Override
	public List<hotels> gethostname() {
		String sql="select host_name,comments from hotel order by comments desc limit 10";
		List<hotels> lst = new ArrayList<hotels>();
		try {
			lst = run.query(sql, new BeanListHandler<hotels>(hotels.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	
	@Override
	public List<hotels> getInfosHotel(String area, String hotelType) {
		//率高，酒店价格（根据某个地区某个房型）有哪些
		String sql = "select  *from hotel where nei_group=? and room_type=?  order by reviews_per_month desc limit 10";
		Object[] params ={area,hotelType};
		List<hotels> lst = new ArrayList<hotels>();
 		//hotels h=null;
		try {
			lst=run.query(sql, new BeanListHandler<hotels>(hotels.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	
	@Override
	public List<Map<String,Object>> getHotelsNums() {
		String sql="select nei_group ,count(*) as nums  from hotel  group by nei_group ";
		//将结果集每一行数据，以Map<列名，Value>封装在Map集合里，并将所有Map集合存储在List
		List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>() ;
		
		try {
			lst=run.query(sql, new MapListHandler());
		//	lst=run.query(sql, new ColumnListHandler());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return lst;
	}
	
	public List<hotels> queryAllhotelMap() throws SQLException {
		// TODO Auto-generated method stub
		String sql ="SELECT  `name`,longitude,latitude from hotel WHERE ava_365>300 and nums>5 AND reviews_per_month>0.5";
		return run.query(sql, new BeanListHandler<>(hotels.class)); 
	}


	@Override
	public List<hotels> getHotelByAeraAndComments() {
		//中心地区按照评论数最多前十
				String sql ="SELECT *from hotel where nei_group = 'Central Region'  order by  comments desc  limit 10";
				List<hotels> lst = new ArrayList<hotels>();
				try {
					return run.query(sql, new BeanListHandler<>(hotels.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lst;
	}


	@Override
	public List<Map<String, Object>> getHotelByAeraAndPrice() {
		// 根据地区分组，查询价格最高的酒店信息
				String sql="select   nei_group,name,MAX(price) as price from hotel GROUP by nei_group  ";
				//将结果集每一行数据，以Map<列名，Value>封装在Map集合里，并将所有Map集合存储在List
				List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>() ;
				
				try {
					lst=run.query(sql, new MapListHandler());
				
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				return lst;
	}
	
	public static void main(String[] args) {
		HotelsDao dao = new HotelsDaoImpl();
		System.out.println(dao.getHotelsNums());
	}
	
}





/*
 * public List<hotels> getGoods() {
		String sql="select * from hotel limit 1";
		List<hotels> lst = new ArrayList<hotels>();
		try {
			lst = runner.query(sql, new BeanListHandler<hotels>(hotels.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
 * */
 