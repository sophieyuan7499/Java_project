package gunviolence.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import gunviolence.model.gunviolence;

public interface gunviolenceDao {
	//�永������ֲ�
	
	//���������϶�İ�����λ��
	public List<gunviolence> getMap() throws SQLException ;
	//ǹ֧��Դ��Ҫ����Щ
	//ǹ֧����
	//����ͳ��ǹɱ��
	public List<Map<String,Object>> getCountByDay()throws SQLException;
	//����ͳ��ǹɱ��
	public List<Map<String,Object>> getCountByMonth()throws SQLException;
	//����ͳ��ǹɱ��
	public List<Map<String,Object>> getCountByYear()throws SQLException;
	//����ͳ��ǹɱ��
	public List<Map<String,Object>> getCountByState()throws SQLException;
	//������ͳ��ǹɱ��
	public List<Map<String,Object>> getCountByCity()throws SQLException;
	
}
