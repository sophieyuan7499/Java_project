package dao;

import java.util.List;

import model.comment;

public interface commentDao {
	//��
	public void addComment(comment c) ;
	
	
	//��ѯĳ�����ӵ��������ۣ�newid��
	//public comment selectALLcommect(int newsid);


	


	public comment selectALLcommect(int newsid);
	
	
	
	
}
