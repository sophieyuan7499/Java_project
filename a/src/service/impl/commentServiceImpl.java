package service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import  dao.commentDao;
import  dao.impl.commentDaoImpl;
import  model.comment;
import  service.commentService;

public class commentServiceImpl implements commentService{
	private commentDao commdao=new commentDaoImpl();
	
	
	public void add(comment c)  {
		// TODO Auto-generated method stub
		 commdao.addComment(c);
	}

	


	public comment selectALLcommect(int newsid) {
		// TODO Auto-generated method stub
		return  commdao.selectALLcommect(newsid);
	}
	


}
