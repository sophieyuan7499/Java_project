package dao;

import java.util.List;

import model.comment;

public interface commentDao {
	//增
	public void addComment(comment c) ;
	
	
	//查询某个帖子的所有评论（newid）
	//public comment selectALLcommect(int newsid);


	


	public comment selectALLcommect(int newsid);
	
	
	
	
}
