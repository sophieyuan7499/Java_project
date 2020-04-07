package  service;

import java.util.List;

import  model.Comments;



public interface CommentsService {
	/**
	 * 新增回复
	 */
	public boolean addComments(Comments comm);
	/**
	 * 获取回复
	 */
	public List<Comments> getCommentsByNewsId(int newsid);
	/**
	 * 删除回复
	 */
	public boolean deleteCommentsById(int id);   
}
