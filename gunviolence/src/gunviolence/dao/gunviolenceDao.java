package gunviolence.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import gunviolence.model.gunviolence;

public interface gunviolenceDao {
	//涉案人年龄分布
	
	//死伤人数较多的案件的位置
	public List<gunviolence> getMap() throws SQLException ;
	//枪支来源主要是哪些
	//枪支类型
	//按天统计枪杀案
	public List<Map<String,Object>> getCountByDay()throws SQLException;
	//按月统计枪杀案
	public List<Map<String,Object>> getCountByMonth()throws SQLException;
	//按年统计枪杀案
	public List<Map<String,Object>> getCountByYear()throws SQLException;
	//按州统计枪杀案
	public List<Map<String,Object>> getCountByState()throws SQLException;
	//按城市统计枪杀案
	public List<Map<String,Object>> getCountByCity()throws SQLException;
	
}
