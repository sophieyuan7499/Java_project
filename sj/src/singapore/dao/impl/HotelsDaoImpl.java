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
		//�ʸߣ��Ƶ�۸񣨸���ĳ������ĳ�����ͣ�����Щ
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
		//�������ÿһ�����ݣ���Map<������Value>��װ��Map�������������Map���ϴ洢��List
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
		//���ĵ����������������ǰʮ
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
		// ���ݵ������飬��ѯ�۸���ߵľƵ���Ϣ
				String sql="select   nei_group,name,MAX(price) as price from hotel GROUP by nei_group  ";
				//�������ÿһ�����ݣ���Map<������Value>��װ��Map�������������Map���ϴ洢��List
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
 