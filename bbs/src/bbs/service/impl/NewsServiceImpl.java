package bbs.service.impl;

import java.util.List;

import bbs.dao.ContentDao;
import bbs.dao.NewsDao;
import bbs.dao.ipml.ContentDaoImpl;
import bbs.dao.ipml.NewsDaoImpl12;
import bbs.model.news;
import bbs.service.NewsService;



public class NewsServiceImpl implements NewsService{
	private NewsDao newsDao = new NewsDaoImpl12();
	private ContentDao commDao = new  ContentDaoImpl();
	@Override
	public boolean addNews(news new_0) {
		// TODO Auto-generated method stub
		return newsDao.addNews(new_0);
	}

	@Override
	public boolean editNews(news new_0) {
		// TODO Auto-generated method stub
		return newsDao.editNews(new_0);
	}

	@Override
	public List<news> getNews(int PageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return newsDao.getNews(PageIndex, pageSize);
	}

	@Override
	public List<news> getNewsByTitle(String title,int PageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByTitle(title, PageIndex, pageSize);
	}

	@Override
	public news getNewsByNewsId(int newsid) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByNewsId(newsid);
	}

	@Override
	public boolean deleteByNewsId(int newsid) {
		commDao.deleteContentByNewsId(newsid);		
		return newsDao.deleteByNewsId(newsid);
	}

	@Override
	public List<news> getNewsByUserId(int userid, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByUserId(userid, pageIndex, pageSize);
	}
	public static void main(String[] args) {
		NewsServiceImpl n = new NewsServiceImpl();
		List<news> lst = n.getNews(1, 2);
		System.out.println(lst.get(0).getUserid());
		
	}

	@Override
	public int getCountAllNews() {
		// TODO Auto-generated method stub
		return newsDao.getCountAllNews();
	}

	@Override
	public int getCountByTitle(String title) {
		// TODO Auto-generated method stub
		return newsDao.getCountByTitle(title);
	}
}
