package bbs.dao;

import java.util.List;

import bbs.model.news;

public interface NewsDao {
public List<news>  getNews(int PageIndex, int pageSize);//分页显示
public boolean addNews(news a );
public void deleteNews(int id);
public List<news> getNewsByUserId(int userid,int pageIndex,int pageSize) ;  //查看自己发布的贴子
public boolean editNews(news new_0);
public List<news> getNewsByTitle(String title,int PageIndex, int pageSize);

public news getNewsByNewsId(int newsid);
public boolean deleteByNewsId(int newsid);
public int getCountAllNews();
public int getCountByTitle(String title);


}
