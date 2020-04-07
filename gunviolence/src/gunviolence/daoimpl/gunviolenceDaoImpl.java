package gunviolence.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;


import gunviolence.dao.gunviolenceDao;
import gunviolence.model.gunviolence;
import gunviolence.util.JdbcUtil;

public class gunviolenceDaoImpl implements gunviolenceDao{
	private QueryRunner run = new QueryRunner(JdbcUtil.getDataSource());
	

	@Override
	public List<gunviolence> getMap() throws SQLException {
		// TODO Auto-generated method stub
		List<gunviolence> lst=new ArrayList<gunviolence>();
		String sql="select  longitude,latitude,a.n_injured+a.n_killed as 'injuredandkilled' from gvdata1 a ORDER BY(a.n_injured+a.n_killed)DESC LIMIT 200";
		 lst= run.query(sql, new BeanListHandler<>(gunviolence.class));
		 return lst;
	}

	@Override
	public List<Map<String, Object>> getCountByDay() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select date, count(*)  as 'num' from gvdata1  GROUP BY date";
		List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>() ;
		lst=run.query(sql, new MapListHandler());	
		return lst;
	}
@Override
public List<Map<String, Object>> getCountByMonth() throws SQLException {
	// TODO Auto-generated method stub
	String sql="select  count(*),DATE_FORMAT(date,'%Y/%m') from gvdata1 GROUP BY DATE_FORMAT(date, '%Y/%m') ORDER BY count(*) DESC";
	List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>() ;
	lst=run.query(sql, new MapListHandler());	
	return lst;
}
@Override
public List<Map<String, Object>> getCountByYear() throws SQLException {
	// TODO Auto-generated method stub
	String sql="select  count(*),DATE_FORMAT(date,'%Y') from gvdata1 GROUP BY DATE_FORMAT(date,'%Y') ORDER BY count(*) DESC";
	List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>() ;
	lst=run.query(sql, new MapListHandler());	
	return lst;
}
@Override
public List<Map<String, Object>> getCountByState() throws SQLException {
	// TODO Auto-generated method stub
	String sql="select state, COUNT(*) from gvdata1  GROUP BY state ORDER BY  count(*) DESC";
	List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>() ;
	lst=run.query(sql, new MapListHandler());	
	return lst;
}
@Override
public List<Map<String, Object>> getCountByCity() throws SQLException {
	// TODO Auto-generated method stub
	String sql="select city_or_county, COUNT(*) from gvdata1  GROUP BY city_or_county ORDER BY  count(*) DESC";
	List<Map<String,Object>> lst = new ArrayList<Map<String,Object>>() ;
	lst=run.query(sql, new MapListHandler());	
	return lst;
}

public static void main(String[] args) throws SQLException {
gunviolenceDao gv=new gunviolenceDaoImpl();
System.out.println(gv.getCountByDay());
}
	
}
