package bbs.service;

import java.util.List;

import bbs.model.Comment;

public interface CommentService {
	//�������?
	public void add(Comment c);
	//��ѯĳ�������������е�����
	public List<Comment> queryComByNewsid(int newsid);
}
