package  service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import  dao.CommentsDao;
import  dao.impl.CommentsDaoImpl;
import  model.Comments;
import  service.CommentsService;


public class CommentsServiceImpl implements CommentsService{
	
	private CommentsDao commdao = new CommentsDaoImpl();
	@Override
	public boolean addComments(Comments comm) {
		
		return commdao.addComments(comm);
	}
	//获取评论
	@Override
	public List<Comments> getCommentsByNewsId(int newsid) {
		List<Comments> lst = commdao.getCommentsByNewsId(newsid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		for(int i=0;i<lst.size();i++){
			lst.get(i).setDateStr(sdf.format(lst.get(i).getDate()));
			
		}
		return lst;
	}

	@Override
	public boolean deleteCommentsById(int id) {
		// TODO Auto-generated method stub
		return commdao.deleteCommentsById(id);
	}

}
