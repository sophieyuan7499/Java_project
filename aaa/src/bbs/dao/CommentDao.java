package bbs.dao;

import java.util.List;

import bbs.model.Comment;

public interface CommentDao {
	//�������?
	public void addCom(Comment c);
	//��ѯĳ�������������е�����
	public List<Comment> getComByNewsid(int newsid);
	
}
