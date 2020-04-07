package singapore.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import singapore.dao.HotelsDao;
import singapore.dao.impl.HotelsDaoImpl;
import singapore.model.hotels;
import singapore.service.HotelsService;

public class HotelsServiceImpl implements HotelsService{
	private HotelsDao hotelsDao = new HotelsDaoImpl();
	@Override
	public List<hotels> gethostname() {
		return hotelsDao.gethostname();
	}

	@Override
	public List<hotels> getInfosHotel(String area, String hotelType) {
		return   hotelsDao.getInfosHotel(area, hotelType);
	}
	public  List<Map<String,Object>>  getHotelsNums(){
		return hotelsDao.getHotelsNums();
	}
	
	public List<hotels> queryAllhotelMap() throws SQLException{
		return hotelsDao.queryAllhotelMap();
		
		
	}

	@Override
	public List<hotels> getHotelByAeraAndComments() {
		
		return hotelsDao.getHotelByAeraAndComments();
	}

	@Override
	public List<Map<String, Object>> getHotelByAeraAndPrice() {
		// TODO Auto-generated method stub
		return hotelsDao.getHotelByAeraAndPrice();
	}
	
	
	
	
	/*public static void main(String[] args) {
		HotelsServiceImpl u = new HotelsServiceImpl();
		System.out.println(u.gethostname());
	}*/
}
