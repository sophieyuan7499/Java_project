package  service;

import java.util.List;

import  model.news;

public interface newsService {
	
		//������
		public void add(news n);

		// ����idɾ������
		public void delete(int id);

		// ����id�༭����
		public void update( String content,String tile,int id);

		// ��ѯ��������

		public List<news> selectAllnews();

		// ��ѯId����
		public news selectidnews(int id);

		// ����uersid��ѯ����
		public List<news> selectueridnews(int userid);
		//���ݱ����ѯ����
		public List<news> selectuertitlenews(String  title);
	
}
