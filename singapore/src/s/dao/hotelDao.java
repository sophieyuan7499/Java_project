package s.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import s.model.hotel;

public interface hotelDao {
	 List<hotel> queryAllhotel() throws SQLException;
	 List<hotel> queryAllhotelMap() throws SQLException;
	 List<hotel> getHotelByAeraAndComments()throws SQLException;//���ݵ������飬��ѯ���������,ֱ���ñ����
	 List<Map<String, Object>>  getHotelByAeraAndPrice()throws SQLException;// ���ݵ������飬��ѯ�۸���ߵ�
//ÿ�������Ƶ���
	 public List<Map<String, Object>> getHotelnumBytype()throws SQLException;
//��ͬ���;Ƶ�������״ͼ
}