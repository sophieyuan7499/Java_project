package singapore.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import singapore.model.hotels;

public interface HotelsService {
	
	
	public List<hotels> gethostname();
	public List<hotels>  getInfosHotel(String area, String hotelType);
	public  List<Map<String,Object>>  getHotelsNums();
	public List<hotels> queryAllhotelMap() throws SQLException;
	public List<hotels> getHotelByAeraAndComments();//根据地区分组，查询评论数最多,直接用表输出
	public  List<Map<String, Object>>  getHotelByAeraAndPrice();// 根据地区分组，查询价格最高的
}
