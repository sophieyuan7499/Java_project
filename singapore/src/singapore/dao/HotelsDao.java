package singapore.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import singapore.model.hotels;

public interface HotelsDao {
	//评论数前十的十个酒店
		public List<hotels> gethostname();
	//根据地区，房型查看回头率高、有哪些价位酒店	
	//private romm --私人房间   Entire hoome-apt --家庭房  shared room ---公寓
			
		public  List<hotels>  getInfosHotel(String area, String hotelType);	
	//统计每个地区总酒店个数---扇形图
		public  List<Map<String,Object>>  getHotelsNums();
		
		public List<hotels> queryAllhotelMap()throws SQLException;//地图

		public List<hotels> getHotelByAeraAndComments();//根据地区分组，查询评论数最多,直接用表输出
		public  List<Map<String, Object>>  getHotelByAeraAndPrice();// 根据地区分组，查询价格最高的

}
