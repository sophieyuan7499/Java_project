package bbs.dao;

import java.util.List;

import bbs.model.news;

public interface NewsDao {
public List<news>  getNews(int PageIndex, int pageSize);//��ҳ��ʾ
public boolean addNews(news a );
public void deleteNews(int id);
public List<news> getNewsByUserId(int userid,int pageIndex,int pageSize) ;  //�鿴�Լ�����������
public boolean editNews(news new_0);
public List<news> getNewsByTitle(String title,int PageIndex, int pageSize);

public news getNewsByNewsId(int newsid);
public boolean deleteByNewsId(int newsid);
public int getCountAllNews();
public int getCountByTitle(String title);


}
