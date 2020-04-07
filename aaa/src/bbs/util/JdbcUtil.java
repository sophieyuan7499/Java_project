package bbs.util;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static DataSource ds;
	
	//数据�?
	static {
		ds = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
}