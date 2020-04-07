package  service;

import java.util.List;

import  model.comment;

public interface commentService {
	//增
	public void add(comment c) ;
		
		
	//查询某个帖子的所有评论（newid）
	public comment selectALLcommect(int newsid);
	
}
