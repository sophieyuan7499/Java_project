package dao;

import java.util.List;

import model.Comments;

public interface CommentsDao {
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
	/**
	 * 根据newsid删除回复
	 * 
	 */
	public void deleteCommentsByNewsId(int newsid);
}
