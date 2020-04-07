package bbs.service;

import java.util.List;

import bbs.model.News;

public interface NewsService {
	//��������
		public void add(News n);
		
		//����idɾ������
		public void Cancel(int id);
		
		//����id�༭����
		public void update(int id,String content);
		
		//��ѯ��������
		public void lookall();
		
		//����id��ѯ����
		public News queryConById(int id);
		
		//����userid��ѯ����
		public List<News> queryConByUserID(int userid);
		
		public List<News> getallNews(int PageIndex, int pageSize);
		
		public List<News> getNewsByTitle(String title,int PageIndex, int pageSize);
}
