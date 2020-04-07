package bbs.service.impl;

import java.util.List;

import bbs.dao.CommentDao;
import bbs.dao.NewsDao;
import bbs.dao.impl.CommentDaoImpl;
import bbs.dao.impl.NewsDaoImpl;
import bbs.model.Comment;
import bbs.service.CommentService;

public class CommentServiceImpl implements  CommentService{

	private CommentDao cd=new CommentDaoImpl();
	
	@Override
	public void add(Comment c) {
		// TODO Auto-generated method stub
		cd.addCom(c);
	}

	@Override
	public List<Comment> queryComByNewsid(int newsid) {
		// TODO Auto-generated method stub
		return cd.getComByNewsid(newsid);
	}
	
//	public static void main(String[] args) {
//		CommentService cd=new CommentServiceImpl();
////		Comment c=new Comment();
//		
////		c.setId(2);
////		c.setContent("123");
////		c.setDate(null);
////		c.setUserid(2);
////		c.setNuwsid(1);
////		
////		cd.add(c);
//		
//		System.out.println(cd.queryComByNewsid(1));
//	}
}
