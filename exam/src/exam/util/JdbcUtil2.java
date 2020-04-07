package exam.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil2 {
	private static DataSource ds;
	
	//����Դ
	static {
		ds = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
}

