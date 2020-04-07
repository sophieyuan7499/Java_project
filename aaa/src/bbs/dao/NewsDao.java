package bbs.dao;

import java.util.List;

import bbs.model.News;

public interface NewsDao {
	//��������
	public void addContent(News n);
	
	//����idɾ������
	public void CancelCon(int id);
	
	//����id�༭����
	public void updateCon(int id,String content);
	
	//��ѯ��������
	public void allCont();
	
	//����id��ѯ����
	public News getConById(int id);
	
	//����userid��ѯ����
	public List<News> getConByUserID(int userid);
	
	public List<News> getNews(int PageIndex, int pageSize);
	
	public List<News> getNewsByTitle(String title,int PageIndex, int pageSize);
}
