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
	public List<hotels> getHotelByAeraAndComments();//���ݵ������飬��ѯ���������,ֱ���ñ����
	public  List<Map<String, Object>>  getHotelByAeraAndPrice();// ���ݵ������飬��ѯ�۸���ߵ�
}
