package s.daoimpl;

import java.sql.SQLException;

import s.dao.hotelDao;
import s.model.hotel;

public class test {
	public static void main(String[] args) {
		hotelDao hotels=new hotelDaoImpl();
		try {
			for ( hotel  hotel1:
				hotels.queryAllhotelMap()) {
			System.out.println( hotel1.getLongitude());
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			for ( Object num :
				hotels.getHotelnumBytype()) {
			System.out.println( num);
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
