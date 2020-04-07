package singapore.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import singapore.model.hotels;

public interface HotelsDao {
	//������ǰʮ��ʮ���Ƶ�
		public List<hotels> gethostname();
	//���ݵ��������Ͳ鿴��ͷ�ʸߡ�����Щ��λ�Ƶ�	
	//private romm --˽�˷���   Entire hoome-apt --��ͥ��  shared room ---��Ԣ
			
		public  List<hotels>  getInfosHotel(String area, String hotelType);	
	//ͳ��ÿ�������ܾƵ����---����ͼ
		public  List<Map<String,Object>>  getHotelsNums();
		
		public List<hotels> queryAllhotelMap()throws SQLException;//��ͼ

		public List<hotels> getHotelByAeraAndComments();//���ݵ������飬��ѯ���������,ֱ���ñ����
		public  List<Map<String, Object>>  getHotelByAeraAndPrice();// ���ݵ������飬��ѯ�۸���ߵ�

}
