package bbs.service.impl;

import java.util.List;

import bbs.dao.NewsDao;
import bbs.dao.UserDao;
import bbs.dao.impl.NewsDaoImpl;
import bbs.dao.impl.UserDaoImpl;
import bbs.model.News;
import bbs.service.NewsService;

public class NewsServiceImpl implements NewsService{

	private NewsDao nd=new NewsDaoImpl();
	
	@Override
	public void add(News n) {
		// TODO Auto-generated method stub
		nd.addContent(n);
	}

	@Override
	public void Cancel(int id) {
		// TODO Auto-generated method stub
		nd.CancelCon(id);
	}

	@Override
	public void update(int id, String content) {
		nd.updateCon(id, content);
	}

	@Override
	public void lookall() {
		// TODO Auto-generated method stub
		nd.allCont();
	}

	@Override
	public News queryConById(int id) {
		// TODO Auto-generated method stub
		return nd.getConById(id);
	}

	@Override
	public List<News> queryConByUserID(int userid) {
		// TODO Auto-generated method stub
		return nd.getConByUserID(userid);
	}

	@Override
	public List<News> getallNews(int PageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return nd.getNews(PageIndex, pageSize);
	}

	@Override
	public List<News> getNewsByTitle(String title, int PageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return nd.getNewsByTitle(title, PageIndex, pageSize);
	}
	
	public static void main(String[] args) {
	NewsService us=new NewsServiceImpl();
	News n=new News();
	
//	System.out.println(us.getallNews(1, 10));
	
//	n.setId(4);
//	n.setTitle("fff");
//	n.setContent("fff");
//	n.getDate();
//	n.setUserid(2);
//	
//	us.add(n);
//	
//	us.Cancel(2);
	us.update(5, "5");
//	us.lookall();
//	System.out.println(us.queryConById(3));
//	System.out.println(us.queryConByUserID(2));
}
	
}
