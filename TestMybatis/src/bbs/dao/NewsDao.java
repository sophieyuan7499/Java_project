package bbs.dao;

import java.util.List;
import java.util.Map;

import bbs.model.News;

public interface NewsDao {
	public News getNewsById(int id);
	//�������ű����ѯ����
	//����������ű���Ϊ�����ѯ��������
	public List<News> getNewsByTitle(String title);
	//���������������û�id�����ű����ѯ����
	//��mybatis�У�����������ݵĲ���Ϊ�������߶��һ��ʹ��map���Ѳ�����װΪMap
	public List<News> getNewsByUserdAndTitle(Map<String, Object> m);
	
}
