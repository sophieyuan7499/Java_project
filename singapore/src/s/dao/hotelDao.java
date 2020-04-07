package s.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import s.model.hotel;

public interface hotelDao {
	 List<hotel> queryAllhotel() throws SQLException;
	 List<hotel> queryAllhotelMap() throws SQLException;
	 List<hotel> getHotelByAeraAndComments()throws SQLException;//根据地区分组，查询评论数最多,直接用表输出
	 List<Map<String, Object>>  getHotelByAeraAndPrice()throws SQLException;// 根据地区分组，查询价格最高的
//每个地区酒店数
	 public List<Map<String, Object>> getHotelnumBytype()throws SQLException;
//不同房型酒店数，柱状图
}