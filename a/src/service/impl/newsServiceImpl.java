package  service.impl;

import java.util.List;

import dao.newsDao;
import  dao.impl.newDaoImpl;
import  model.news;
import  service.newsService;

public class newsServiceImpl implements newsService {
	private newsDao nn=new newDaoImpl();              //父类引用指向子类对象
	@Override
	public void add(news n) {
		// TODO Auto-generated method stub
		//newDaoImpl newDaoImpl=(newDaoImpl)nn;
		nn.addnews(n);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		nn.deletenews(id);
	}

	public void update(String content,String title, int id ) {
		// TODO Auto-generated method stub
		nn.updatenews(content,title,id);
	}

	@Override
	public List<news> selectAllnews() {
		// TODO Auto-generated method stub
		return nn.selectAllnews();
	}

	@Override
	public news selectidnews(int id) {
		// TODO Auto-generated method stub
		return nn.selectidnews(id);
	}

	@Override
	public List<news> selectueridnews(int userid) {
		// TODO Auto-generated method stub
		return nn.selectueridnews(userid);
	}
	public List<news> selectuertitlenews(String  title) {
		return  nn.selectuertitlenews(title);
	}
}
